package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.employee.admin.ShowingPatientService;
import project.hospital.service.employee.admin.UpdatePatientService;

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
        model.addAttribute("patients", showingPatientService.getPatientList());
        return "patient-list";
    }

    /**
     *
     * @PathVariable  contains firstName and lastName
     */
    @GetMapping("/search-by-name/{firstName}/{lastName}")
    public List<PatientDTO> searchPatientByName(@PathVariable String firstName, @PathVariable String lastName) {
        return showingPatientService.getPatientByFullName(firstName, lastName);
    }

    /**
     *
     * @PathVariable  contains firsName and department
     */
    @GetMapping("search-by-department/{firstName}/{department}")
    public List<PatientDTO> searchPatientByDepartment(@PathVariable String firstName, @PathVariable String department) {
        return showingPatientService.getPatientByDepartment(firstName, department);
    }
    @GetMapping("user-menu")
    public String getAdminMenu(){
        return "user-menu";
    }
}
