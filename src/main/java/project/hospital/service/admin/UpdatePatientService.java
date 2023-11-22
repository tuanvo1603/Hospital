package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.PatientRepository;

@Service
public class UpdatePatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public UpdatePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deleteRecord(PatientDTO patientDTO) {
        String id = patientDTO.getPatientId();
        patientRepository.deleteById(id);
    }

    public void insertPatient(Patient patient) {
        patientRepository.save(patient);
    }
}
