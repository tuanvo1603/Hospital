package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Employee;
import project.hospital.repository.employee.EmployeeRepository;

import java.util.List;

@Service
public class CommonEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public CommonEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeRepository.findAllByDepartmentEqualsIgnoreCase(department);
    }

    public void checkExistenceOfEmployee(Long employeeId) {
        if(!employeeRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }
}
