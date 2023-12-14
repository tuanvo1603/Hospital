package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.employee.admin.ShowingPatientService;

import java.util.List;

@RestController
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
    public List<PatientDTO> listPatients() {
        return showingPatientService.getPatientList();
    }

    /**
     *
     * @PathVariable  contains firstName and lastName
     */
    @GetMapping("/search-by-name/{firstName}/{lastName}")
    public List<Patient> searchPatientByName(@PathVariable String firstName, @PathVariable String lastName) {
        return showingPatientService.getPatientByFullName(firstName, lastName);
    }

    /**
     *
     * @PathVariable  contains firsName and department
     */
    @GetMapping("search-by-department/{firstName}/{department}")
    public List<Patient> searchPatientByDepartment(@PathVariable String firstName, @PathVariable String department) {
        return showingPatientService.getPatientByDepartment(firstName, department);
    }
}
