package project.hospital.controller.employee.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
import project.hospital.service.employee.admin.UpdatePatientService;

@Controller
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

    @PostMapping("/add-patient-form")
    public String approvePatient(@RequestBody Outpatient outpatient) {
        updatePatientService.insertPatient(outpatient);
        return "patient-list";
    }

    @CrossOrigin
    @DeleteMapping("/patient-list/{patientId}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long patientId) {
        updatePatientService.dischargePatient(patientId);
        return ResponseEntity.ok("Discharge successfully");
    }

    @GetMapping("/add-patient-form")
    public String getAddPatientPage(){
        return "add-patient-form";
    }
}





