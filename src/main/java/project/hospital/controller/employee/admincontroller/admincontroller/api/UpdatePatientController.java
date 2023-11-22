package project.hospital.controller.employee.admincontroller.admincontroller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.admin.UpdatePatientService;

@RestController
public class UpdatePatientController {
    private final UpdatePatientService updatePatientService;

    @Autowired
    public UpdatePatientController(UpdatePatientService insertionService) {
        this.updatePatientService = insertionService;
    }

    @PostMapping("/admitPatient")
    public String approvePatient(@RequestBody Patient patient) {
        updatePatientService.insertPatient(patient);
        return "login";
    }

    @PostMapping("/discharge-patient")
    public void dischargePatient(@RequestBody PatientDTO patientDTO) {
        updatePatientService.deleteRecord(patientDTO);
    }
}





