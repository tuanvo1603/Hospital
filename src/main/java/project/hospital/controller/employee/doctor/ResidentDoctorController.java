package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.repository.employee.EmployeeRepository;

@RestController
@RequestMapping("/resident-doctor")
public class ResidentDoctorController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public ResidentDoctorController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


}
