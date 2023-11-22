package project.hospital.controller.employee.secretarycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.employee.*;
import project.hospital.service.employee.secretary.ManagingEmployeeService;

@RestController
@RequestMapping("/secretary")
public class ManagingEmployeeController {

    private final ManagingEmployeeService managingEmployeeService;

    @Autowired
    public ManagingEmployeeController(ManagingEmployeeService managingEmployeeService) {
        this.managingEmployeeService = managingEmployeeService;
    }
    @PostMapping("/delete-employee")
    public ResponseEntity<Void> deleteEmployee(@RequestBody String employeeId) {
        managingEmployeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/insert-doctor")
    public Employee insertDoctor(@RequestBody Doctor doctor) {
        managingEmployeeService.insertDoctor(doctor);
        return doctor;
    }

    @PostMapping("/insert-technician")
    public Employee insertDoctor(@RequestBody Technician technician) {
        managingEmployeeService.insertTechnician(technician);
        return technician;
    }

    @PostMapping("/insert-nurse")
    public Employee insertDoctor(@RequestBody Nurse nurse) {
        managingEmployeeService.insertNurse(nurse);
        return nurse;
    }

    @PostMapping("/insert-administrator")
    public Employee insertDoctor(@RequestBody Administrator administrator) {
        managingEmployeeService.insertAdministrator(administrator);
        return administrator;
    }

    @PostMapping("/insert-interner")
    public Employee insertDoctor(@RequestBody Interner interner) {
        managingEmployeeService.insertInterner(interner);
        return interner;
    }
}
