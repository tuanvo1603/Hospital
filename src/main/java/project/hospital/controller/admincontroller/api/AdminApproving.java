package project.hospital.controller.admincontroller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.Patient;
import project.hospital.service.admin.InsertionPatientService;

@RestController
@Configuration
public class AdminApproving {
    private final InsertionPatientService insertionPatientService;
    @Autowired
    public AdminApproving(InsertionPatientService insertionService) {
        this.insertionPatientService = insertionService;
    }

    @PostMapping("/admitPatient")
    public String approvePatient(@RequestBody Patient patient) {
        insertionPatientService.insertPatient(patient);
        return "login";
    }
}





