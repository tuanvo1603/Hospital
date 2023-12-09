package project.hospital.service.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.repository.employee.EmployeeRepository;

import java.util.List;

@Service
public class ManagingEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public ManagingEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> showDepartmentEmployees(String department) {
        return employeeRepository.showDepartmentEmployees(department);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}
