package project.hospital.service.employee.secretary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.repository.employee.EmployeeRepository;

@Service
public class ManagingEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public ManagingEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void insertDoctor(Doctor doctor) {
        employeeRepository.save(doctor);
    }

    public void insertTechnician(Technician technician) {
        employeeRepository.save(technician);
    }

    public void insertNurse(Nurse nurse) {
        employeeRepository.save(nurse);
    }

    public void insertAdministrator(Administrator administrator) {
        employeeRepository.save(administrator);
    }

    public void insertInterner(Interner interner) {
        employeeRepository.save(interner);
    }

}
