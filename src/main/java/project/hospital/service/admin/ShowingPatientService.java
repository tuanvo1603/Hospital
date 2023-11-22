package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientRepositoryDTO;

import java.util.List;

@Service
public class ShowingPatientService {
    private final PatientRepositoryDTO patientRepositoryDTO;

    @Autowired
    public ShowingPatientService(PatientRepositoryDTO patientRepositoryDTO) {
        this.patientRepositoryDTO = patientRepositoryDTO;
    }

    public List<PatientDTO> findPatients() {
        return patientRepositoryDTO.findPatients();
    }
}
