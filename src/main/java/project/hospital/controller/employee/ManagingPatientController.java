package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hospital.service.employee.ManagingPatientService;

@Controller
@RequestMapping("/employee")
public class ManagingPatientController {

    private final ManagingPatientService managingPatientService;

    @Autowired
    public ManagingPatientController(ManagingPatientService managingPatientService) {
        this.managingPatientService = managingPatientService;
    }

//    @GetMapping("/patient-list")
//    public String findManagedPatients(
//            @RequestBody String employeeId,
//            Model model
//    ) {
//        model.addAttribute("patients", managingPatientService.findManagedPatients(employeeId));
//        return "patient-list";
//    }

}
