package project.hospital.service.employee.doctor.specialistdoctor;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.ternary.RTI;
import project.hospital.model.ternary.STO;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.repository.ternary.RTIRepository;
import project.hospital.repository.ternary.STORepository;

@Service
public class SpecialistDoctorService {

    private final InpatientRepository inpatientRepository;
    private final OutpatientRepository outpatientRepository;
    private final STORepository stoRepository;
    private final RTIRepository rtiRepository;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Autowired
    public SpecialistDoctorService(
            InpatientRepository inpatientRepository,
            OutpatientRepository outpatientRepository,
            STORepository stoRepository,
            RTIRepository rtiRepository,
            EntityManager entityManager) {
        this.inpatientRepository = inpatientRepository;
        this.outpatientRepository = outpatientRepository;
        this.stoRepository = stoRepository;
        this.rtiRepository = rtiRepository;
        this.entityManager = entityManager;
    }

    private void deleteOutpatient(Outpatient outpatient) {
        outpatientRepository.delete(outpatient);
    }

    private void initRTIFromSTO(STO sto) {
        RTI rti = new RTI();
        rti.setTreatmentId(sto.getTreatmentId());
        rti.setPatientId(sto.getPatientId());
        rtiRepository.saveAndFlush(rti);
    }

    private Outpatient copyPatientInfo(Inpatient oldInpatient) throws PatientCanNotBeFoundException {
        Outpatient outpatient = entityManager.merge(outpatientRepository
                                                    .findById(oldInpatient.getPatientId())
                                                    .orElseThrow(PatientCanNotBeFoundException::new));
        inpatientRepository.copyOutpatientInfo(outpatient.getPatientId());
        return outpatient;
    }

    private STO getPatientSTO(Outpatient outpatient) throws PatientCanNotBeFoundException {
        return entityManager.merge(stoRepository
                .findById(outpatient.getPatientId())
                .orElseThrow(PatientCanNotBeFoundException::new));
    }

    private void deleteSTO(STO sto) {
        stoRepository.deleteSto(sto.getPatientId());
    }

    @Transactional
    public void admissionPatient(Inpatient inpatient) throws PatientCanNotBeFoundException {
        Outpatient outpatient = this.copyPatientInfo(inpatient);
        STO oldSto = this.getPatientSTO(outpatient);
        this.initRTIFromSTO(oldSto);
        this.deleteSTO(oldSto);
        this.deleteOutpatient(outpatient);
    }
}
