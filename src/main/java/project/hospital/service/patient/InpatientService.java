package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.PatientRepository;

@Service
public class InpatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public InpatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient showInpatientInformation(String patientId) {
        return patientRepository.findById(patientId).get();
    }

}
