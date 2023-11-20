package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.Patient;
import project.hospital.repository.patient.PatientRepository;

@Service
public class InsertionPatientService {

    private final PatientRepository patientRepository;
    @Autowired
    public InsertionPatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void insertPatient(Patient patient) {
        patientRepository.save(patient);
    }

}
