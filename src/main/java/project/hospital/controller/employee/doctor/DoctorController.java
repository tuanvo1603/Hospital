//package project.hospital.controller.employee.doctor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import project.hospital.service.employee.doctor.DoctorService;
//
//@RestController
//@RequestMapping("/doctor")
//public class DoctorController {
//
//    private final DoctorService doctorService;
//
//    @Autowired
//    public DoctorController(DoctorService doctorService) {
//        this.doctorService = doctorService;
//    }
//
//    @PostMapping("/change-patient-department")
//    public ResponseEntity<Void> changePatientDepartment(
//            @RequestBody String patientId,
//            @RequestBody String department
//    ) {
//        doctorService.changePatientDepartment(patientId, department);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//}
