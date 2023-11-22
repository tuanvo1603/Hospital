//package project.hospital.controller.employee.secretarycontroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import project.hospital.service.employee.secretary.WorkingWithEmployeeService;
//
//@RestController
//public class UpdateEmployeeController {
//
//    private final WorkingWithEmployeeService workingWithEmployeeService;
//
//    @Autowired
//    public UpdateEmployeeController(WorkingWithEmployeeService workingWithEmployeeService) {
//        this.workingWithEmployeeService = workingWithEmployeeService;
//    }
//    @PostMapping("/delete-employee")
//    public ResponseEntity<Void> deleteEmployee(@RequestBody String employeeId) {
//        workingWithEmployeeService.deleteEmployee(employeeId);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//}
