package project.hospital.controller.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.model.employee.*;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.service.employee.doctor.dean.DeanService;

import java.util.List;

@RestController
@RequestMapping("/dean/manage-employee")
public class ManagingEmployeeController {
    /**
     * Done
     */
    private final DeanService deanService;

    @Autowired
    public ManagingEmployeeController(DeanService deanService) {
        this.deanService = deanService;
    }

    @PostMapping("/delete-employee")
    public ResponseEntity<Void> deleteEmployee(@RequestBody Long employeeId) {
        deanService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/show-department-employees")
    public List<Employee> showDepartmentEmployees(@RequestBody String department) {
        return deanService.showDepartmentEmployees(department);
    }

    @PostMapping("/insert-resident-doctor")
    public ResponseEntity<String> insertResidentDoctor(@RequestBody ResidentDoctor doctor) {
        deanService.insertEmployee(doctor);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-specialist-doctor")
    public ResponseEntity<String> insertSpecialistDoctor(@RequestBody SpecialistDoctor doctor) {
        deanService.insertEmployee(doctor);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-technician")
    public ResponseEntity<String> insertTechnician(@RequestBody Technician technician) {
        deanService.insertEmployee(technician);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-nurse")
    public ResponseEntity<String> insertNurse(@RequestBody Nurse nurse) {
        deanService.insertEmployee(nurse);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-administrator")
    public ResponseEntity<String> insertAdministrator(@RequestBody Administrator administrator) {
        deanService.insertEmployee(administrator);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-medical-intern")
    public ResponseEntity<String> insertMedicalIntern(@RequestBody MedicalIntern medicalIntern) {
        deanService.insertEmployee(medicalIntern);
        return ResponseEntity.ok("Insert successfully");
    }

    @PostMapping("/insert-tech-intern")
    public ResponseEntity<String> insertTechIntern(@RequestBody TechIntern techIntern) {
        deanService.insertEmployee(techIntern);
        return ResponseEntity.ok("Insert successfully");
    }
}
