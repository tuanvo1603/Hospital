package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/admission-patient")
    public void admissionPatient(@RequestBody Inpatient inpatient) throws PatientCanNotBeFoundException {
        specialistDoctorService.admissionPatient(inpatient);
    }
}
