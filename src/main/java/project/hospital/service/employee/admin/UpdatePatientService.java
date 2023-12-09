package project.hospital.service.employee.admin;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.ternary.STO;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.repository.ternary.STORepository;
import project.hospital.repository.treatment.TreatmentRepository;

@Service
public class UpdatePatientService {

    private final OutpatientRepository outpatientRepository;
    private final TreatmentRepository treatmentRepository;
    private final STORepository stoRepository;
    @Autowired
    public UpdatePatientService(OutpatientRepository outpatientRepository, TreatmentRepository treatmentRepository, STORepository stoRepository) {
        this.outpatientRepository = outpatientRepository;
        this.treatmentRepository = treatmentRepository;
        this.stoRepository = stoRepository;
    }

    public void dischargePatient(PatientDTO patientDTO) {
        Long id = patientDTO.getPatientId();
        outpatientRepository.deleteById(id);
    }

    private void initSTO(Outpatient outpatient, Treatment treatment) {
        STO sto = new STO();
        sto.setTreatmentId(treatment.getTreatmentId());
        sto.setPatientId(outpatient.getPatientId());
        stoRepository.save(sto);
    }

    private void initHospitalFee(Treatment treatment) {
        HospitalFee hospitalFee = new HospitalFee();
        treatment.setHospitalFee(hospitalFee);
        hospitalFee.setTreatmentId(treatment.getTreatmentId());
        treatmentRepository.save(treatment);
    }

    private Treatment initTreatment() {
        return treatmentRepository.save(new Treatment());
    }

    private Outpatient initOutpatient(Outpatient outpatient) {
        return outpatientRepository.save(outpatient);
    }

    @Transactional
    public void insertPatient(Outpatient outpatient) {
        Outpatient insertedPatient = this.initOutpatient(outpatient);
        Treatment insertedTreatment = this.initTreatment();
        initSTO(insertedPatient, insertedTreatment);
        initHospitalFee(insertedTreatment);
    }

}
