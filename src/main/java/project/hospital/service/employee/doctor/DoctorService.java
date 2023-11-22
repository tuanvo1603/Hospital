package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientRepositoryDTO;

import java.util.List;

public class DoctorService {

    private final PatientRepositoryDTO patientRepositoryDTO;

    @Autowired
    public DoctorService(PatientRepositoryDTO patientRepositoryDTO) {
        this.patientRepositoryDTO = patientRepositoryDTO;
    }

}
