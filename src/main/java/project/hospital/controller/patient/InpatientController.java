package project.hospital.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.PatientService;

import java.util.List;

@RestController
@RequestMapping("/inpatient")
public class InpatientController {
    /**
     * Done
     */
    private final InpatientService inpatientService;

    @Autowired
    public InpatientController(InpatientService inpatientService) {
        this.inpatientService = inpatientService;
    }

    @GetMapping("/my-information/{patientId}")
    public ResponseEntity<Patient> showPatientInformation(@PathVariable Long patientId) throws PatientCanNotBeFoundException {
        System.out.println(patientId);
        return ResponseEntity.ok(inpatientService.showPatientInfo(patientId));
    }
}
