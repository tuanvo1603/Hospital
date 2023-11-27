package project.hospital.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.patient.Inpatient;
import project.hospital.service.patient.InpatientService;

import java.util.List;

@RestController
@RequestMapping("/inpatient")
public class InpatientController {

    private final InpatientService inpatientService;

    @Autowired
    public InpatientController(InpatientService inpatientService) {
        this.inpatientService = inpatientService;
    }

    @GetMapping("/my-information")
    public ResponseEntity<Inpatient> showInpatientInformation(@RequestBody String patientId) {
        return ResponseEntity.ok(inpatientService.showInpatientInformation(patientId));
    }

}
