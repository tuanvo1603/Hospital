package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.repository.employee.EmployeeRepository;

@Service
public class InternalWorkingService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public InternalWorkingService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public WorkingSchedule checkWorkingSchedule(String employeeId) {
        return employeeRepository.findById(employeeId).get().getWorkingSchedule();
    }

    public Employee checkMyInformation(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }
}
