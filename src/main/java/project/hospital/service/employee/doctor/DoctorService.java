package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.repository.employee.EmployeeRepository;
@Service
public class DoctorService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DoctorService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
