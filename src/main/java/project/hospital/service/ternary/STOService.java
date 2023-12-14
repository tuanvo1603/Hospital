package project.hospital.service.ternary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.ternary.STO;
import project.hospital.model.ternary.Ternary;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.ternary.STORepository;
@Service
public class STOService {

    private final STORepository stoRepository;

    @Autowired
    public STOService(STORepository stoRepository) {
        this.stoRepository = stoRepository;
    }

    @Transactional
    public void deleteSTOById(Long patientId) {
        stoRepository.deleteById(patientId);
    }

    @Transactional
    public void initSTO(Patient outpatient, Treatment treatment) {
        STO sto = new STO();
        sto.setTreatmentId(treatment.getTreatmentId());
        sto.setPatientId(outpatient.getPatientId());
        stoRepository.save(sto);
    }

    public STO getPatientFromSTO(Long patientId) throws PatientCanNotBeFoundException {
        return stoRepository
                .findById(patientId)
                .orElseThrow(PatientCanNotBeFoundException::new);
    }

}
