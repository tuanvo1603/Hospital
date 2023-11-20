package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientRepository;

@Service
public class DischargingPatientService{

    private final PatientRepository patientRepository;

    @Autowired
    public DischargingPatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deleteRecord(PatientDTO patientDTO) {
        String id = patientDTO.getPatientId();
        patientRepository.deleteById(id);
    }
}
