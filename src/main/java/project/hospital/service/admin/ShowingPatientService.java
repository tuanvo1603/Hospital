package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientRepositoryDTO;

import java.util.List;

@Service
public class ShowingPatientService {
    private final PatientRepositoryDTO patientRepository;
    @Autowired
    public ShowingPatientService(PatientRepositoryDTO patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> findAllPatients() {
        return patientRepository.findAllPatients();
    }
}
