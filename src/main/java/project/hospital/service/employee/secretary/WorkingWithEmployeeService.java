package project.hospital.service.employee.secretary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.employee.Employee;
import project.hospital.repository.patient.PatientRepositoryDTO;
import project.hospital.repository.secretary.SecretaryRepository;

import java.util.List;

@Service
public class WorkingWithEmployeeService {

    private final SecretaryRepository secretaryRepository;

    public WorkingWithEmployeeService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

}
