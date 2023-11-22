package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientRepositoryDTO;

import java.util.List;

@Service
public class EmployeeService {

    private final PatientRepositoryDTO patientRepositoryDTO;

    @Autowired
    public EmployeeService(PatientRepositoryDTO patientRepositoryDTO) {
        this.patientRepositoryDTO = patientRepositoryDTO;
    }

    public List<PatientDTO> findManagedPatients(String employeeId) {
        return patientRepositoryDTO.findManagedPatients(employeeId);
    }
}
