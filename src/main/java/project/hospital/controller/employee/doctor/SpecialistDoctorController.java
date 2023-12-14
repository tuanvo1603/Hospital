package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.service.employee.doctor.SpecialistDoctorService;

@RestController
@RequestMapping("/specialist-doctor")
public class SpecialistDoctorController {
    /**
     * Done
     */
    private final SpecialistDoctorService specialistDoctorService;

    @Autowired
    public SpecialistDoctorController(SpecialistDoctorService specialistDoctorService) {
        this.specialistDoctorService = specialistDoctorService;
    }

    @PostMapping("/admit-inpatient/{patientId}")
    public ResponseEntity<String> admissionPatient(@PathVariable Long patientId) throws PatientCanNotBeFoundException {
        specialistDoctorService.admitInpatient(patientId);
        return ResponseEntity.ok("Admit inpatient successfully");
    }
}
