package project.hospital.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.PatientService;

@RestController
@RequestMapping("/inpatient")
public class PatientController {
    /**
     * Done
     */
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/my-information")
    public ResponseEntity<Patient> showPatientInformation(@RequestBody Long patientId) {
        return ResponseEntity.ok(patientService.showInpatientInformation(patientId));
    }

}
