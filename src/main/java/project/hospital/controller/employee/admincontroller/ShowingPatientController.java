package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hospital.service.admin.ShowingPatientService;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/admin/show")
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

    @GetMapping("/search-by-name")
    public String searchPatientByName(Model model, @RequestBody ArrayList<String> patientInfo) {
        model.addAttribute("patients", showingPatientService.searchPatientByFullName(patientInfo));
        return "patient-list";
    }

    @GetMapping("search-by-department")
    public String searchPatientByDepartment(Model model, @RequestBody ArrayList<String> patientInfo) {
        model.addAttribute("patients", showingPatientService.searchPatientByDepartment(patientInfo));
        return "patient-list";
    }
}
