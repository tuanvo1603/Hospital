package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.employee.admin.UpdatePatientService;

@RestController
@RequestMapping("/admin/update")
public class UpdatePatientController {
    /**
     Done
     */
    private final UpdatePatientService updatePatientService;

    @Autowired
    public UpdatePatientController(UpdatePatientService insertionService) {
        this.updatePatientService = insertionService;
    }

    @PostMapping("/admit-patient")
    public String approvePatient(@RequestBody Patient patient) {
        updatePatientService.insertPatient(patient);
        return "login";
    }

    @PostMapping("/discharge-patient")
    public void dischargePatient(@RequestBody PatientDTO patientDTO) {
        updatePatientService.dischargePatient(patientDTO);
    }

}





