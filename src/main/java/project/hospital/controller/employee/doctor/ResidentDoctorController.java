package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.service.employee.doctor.residentdoctor.ResidentDoctorService;

@RestController
@RequestMapping("/resident-doctor")
public class ResidentDoctorController {

    private final ResidentDoctorService residentDoctorService;

    @Autowired
    public ResidentDoctorController(ResidentDoctorService residentDoctorService) {
        this.residentDoctorService = residentDoctorService;
    }

    @PatchMapping("/update-inpatient")
    public ResponseEntity<Void> updateInpatient(Inpatient inpatient) {
        residentDoctorService.updateInpatient(inpatient);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/change-patient-department")
//    public ResponseEntity<Void> changePatientDepartment(
//            @RequestBody String patientId,
//            @RequestBody String department
//    ) {
//        residentDoctorService.changePatientDepartment(patientId, department);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
