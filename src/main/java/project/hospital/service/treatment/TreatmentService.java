package project.hospital.service.treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.TreatmentNotFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.treatment.TreatmentRepository;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    @Autowired
    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Transactional
    public Treatment createTreatment(Long patientId) {
        Treatment treatment = new Treatment();
        treatment.setPatientId(patientId);
        return treatmentRepository.save(treatment);
    }

    @Transactional
    public Treatment createTreatment(Patient patient) {
        Treatment treatment = new Treatment();
        treatment.setPatient(patient);
        return treatmentRepository.save(treatment);
    }

    public Treatment createTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public void deleteTreatment(Long patientId) {
        treatmentRepository.deleteById(patientId);
    }

    public void updateTreatment(Long patientId, Treatment treatment) {
        if(treatmentRepository.existsById(patientId))
            treatmentRepository.save(treatment);
        else
            throw new TreatmentNotFoundException();
    }

    public Treatment getTreatmentById(Long patientId){
        return treatmentRepository.findById(patientId).orElseThrow(TreatmentNotFoundException::new);
    }
}
