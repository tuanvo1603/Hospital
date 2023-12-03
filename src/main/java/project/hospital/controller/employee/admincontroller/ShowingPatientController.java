package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.hospital.service.employee.admin.ShowingPatientService;

import java.util.List;

@Controller
@RequestMapping("/admin/show")
public class ShowingPatientController {
    /**
     * Done
     */

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

    /**
     *
     * @param patientInfo contains firstName and lastName
     */
    @GetMapping("/search-by-name")
    public String searchPatientByName(Model model, @RequestBody List<String> patientInfo) {
        model.addAttribute("patients", showingPatientService.searchPatientByFullName(patientInfo));
        return "patient-list";
    }

    /**
     *
     * @param patientInfo contains firsName and department
     */
    @GetMapping("search-by-department")
    public String searchPatientByDepartment(Model model, @RequestBody List<String> patientInfo) {
        model.addAttribute("patients", showingPatientService.searchPatientByDepartment(patientInfo));
        return "patient-list";
    }
}
