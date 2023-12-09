package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.service.employee.doctor.residentdoctor.ResidentDoctorService;

@RestController
@RequestMapping("/resident-doctor/{employeeId}")
public class ResidentDoctorController {

    private final ResidentDoctorService residentDoctorService;

    @Autowired
    public ResidentDoctorController(ResidentDoctorService residentDoctorService) {
        this.residentDoctorService = residentDoctorService;
    }

    @PutMapping("/update-inpatient")
    public ResponseEntity<Void> updateInpatient(
            @RequestBody Inpatient inpatient,
            @PathVariable Long employeeId) throws PatientCanNotBeFoundException,
                                                                    IncorrectIdException
    {
        residentDoctorService.updateInpatient(inpatient, employeeId);
        return ResponseEntity.ok().build();
    }

}
