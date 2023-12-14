package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
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
    public ResponseEntity<String> approvePatient(@RequestBody Outpatient outpatient) {
        updatePatientService.insertPatient(outpatient);
        return ResponseEntity.ok("Insert successfully");
    }

    @DeleteMapping("/discharge-patient/{patientId}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long patientId) {
        updatePatientService.dischargePatient(patientId);
        return ResponseEntity.ok("Discharge successfully");
    }

}




