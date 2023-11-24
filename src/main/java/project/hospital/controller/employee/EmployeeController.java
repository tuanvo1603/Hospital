package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hospital.service.employee.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/patient-list")
    public String findManagedPatients(
            @RequestBody String employeeId,
            Model model
    ) {
        model.addAttribute("patients", employeeService.findManagedPatients(employeeId));
        return "patient-list";
    }
}
