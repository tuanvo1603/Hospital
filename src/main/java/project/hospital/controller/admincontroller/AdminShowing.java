package project.hospital.controller.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.hospital.service.admin.ShowingPatientService;

@Configuration
@Controller
public class AdminShowing {

        private final ShowingPatientService patientInformationService;
        @Autowired
        public AdminShowing(ShowingPatientService patientInformationService) {
            this.patientInformationService = patientInformationService;
        }

        @GetMapping("/patient-list")
        public String listPatients(Model model) {
            model.addAttribute("patients", patientInformationService.findAllPatients());
            return "patient-list";
        }

    @GetMapping("/approve-patient")
    public String getApprovePatientForm() {
        return "approve-patient-form";
    }
}
