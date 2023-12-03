package project.hospital.controller.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.model.employee.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.service.employee.doctor.dean.ManagingEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/dean/manage-employee")
public class ManagingEmployeeController {
    /**
     * Done
     */
    private final ManagingEmployeeService managingEmployeeService;

    @Autowired
    public ManagingEmployeeController(ManagingEmployeeService managingEmployeeService) {
        this.managingEmployeeService = managingEmployeeService;
    }

    public <T extends Employee> ResponseEntity<Void> insertEmployee(T t) {
        managingEmployeeService.insertEmployee(t);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/delete-employee")
    public ResponseEntity<Void> deleteEmployee(@RequestBody String employeeId) {
        managingEmployeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/show-department-employees")
    public List<Employee> showDepartmentEmployees(@RequestBody String department) {
        return managingEmployeeService.showDepartmentEmployees(department);
    }

    @PostMapping("/insert-resident-doctor")
    public ResponseEntity<Void> insertResidentDoctor(@RequestBody ResidentDoctor doctor) {
        return this.insertEmployee(doctor);
    }

    @PostMapping("/insert-specialist-doctor")
    public ResponseEntity<Void> insertSpecialistDoctor(@RequestBody SpecialistDoctor doctor) {
        return this.insertEmployee(doctor);
    }

    @PostMapping("/insert-technician")
    public ResponseEntity<Void> insertTechnician(@RequestBody Technician technician) {
        return this.insertEmployee(technician);
    }

    @PostMapping("/insert-nurse")
    public ResponseEntity<Void> insertNurse(@RequestBody Nurse nurse) {
        return this.insertEmployee(nurse);
    }

    @PostMapping("/insert-administrator")
    public ResponseEntity<Void> insertAdministrator(@RequestBody Administrator administrator) {
        return this.insertEmployee(administrator);
    }

    @PostMapping("/insert-medical-intern")
    public ResponseEntity<Void> insertMedicalIntern(@RequestBody MedicalIntern medicalIntern) {
        return this.insertEmployee(medicalIntern);
    }

    @PostMapping("/insert-tech-intern")
    public ResponseEntity<Void> insertTechIntern(@RequestBody TechIntern techIntern) {
        return this.insertEmployee(techIntern);
    }
}
