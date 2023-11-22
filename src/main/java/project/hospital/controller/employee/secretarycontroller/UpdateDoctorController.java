//package project.hospital.controller.employee.secretarycontroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import project.hospital.model.employee.Doctor;
//
//@RestController
//public class UpdateDoctorController {
//
//    private final WorkingWithDoctorService workingWithDoctorService;
//
//    @Autowired
//    public UpdateDoctorController(WorkingWithDoctorService workingWithDoctorService) {
//        this.workingWithDoctorService = workingWithDoctorService;
//    }
//
//    @PostMapping("/insert-doctor")
//    public Doctor insertDoctor(Doctor doctor) {
//        workingWithDoctorService.insertDoctor(doctor);
//        return doctor;
//    }
//}
