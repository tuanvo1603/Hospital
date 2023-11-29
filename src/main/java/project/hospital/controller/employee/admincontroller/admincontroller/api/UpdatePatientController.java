package project.hospital.controller.employee.admincontroller.admincontroller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.dto.PatientList;
import project.hospital.model.patient.Patient;
import project.hospital.service.admin.UpdatePatientService;

@RestController
public class UpdatePatientController {
    private final UpdatePatientService updatePatientService;

    @Autowired
    public UpdatePatientController(UpdatePatientService insertionService) {
        this.updatePatientService = insertionService;
    }

    @PostMapping("/add-patient")
    public String approvePatient(@RequestBody Patient patient) {
        updatePatientService.insertPatient(patient);
        return "patient-list";
    }

    @DeleteMapping("patient-list")
    public void dischargePatient(@RequestBody PatientList patientList) {
        updatePatientService.deleteRecord(patientList);
    }
}





