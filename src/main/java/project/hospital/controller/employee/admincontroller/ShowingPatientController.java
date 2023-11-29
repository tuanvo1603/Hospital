package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.hospital.service.admin.ShowingPatientService;

@Controller
public class ShowingPatientController {

    private final ShowingPatientService showingPatientService;

    @Autowired
    public ShowingPatientController(ShowingPatientService showingPatientService) {
        this.showingPatientService = showingPatientService;
    }

    @GetMapping("/patient-list")
    public String listPatients(Model model) {
        model.addAttribute("patients", showingPatientService.findPatients());
        return "patient-list";
    }

    @GetMapping("/approve-patient")
    public String getApprovePatientForm() {
        return "approve-patient-form";
    }

    @GetMapping("/add-patient")
    public String insertPatient(){
        return "add-patient";
    }
}
