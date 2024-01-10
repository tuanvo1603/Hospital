package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.employee.Administrator;
import project.hospital.model.employee.Employee;
import project.hospital.model.employee.Nurse;
import project.hospital.model.employee.Technician;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.employee.NurseService;
import project.hospital.service.employee.TechnicianService;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.schedule.WorkingScheduleService;
import project.hospital.service.treatment.prescription.MedicationService;
import project.hospital.service.treatment.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/dean/manage-employee")
@PreAuthorize("hasRole('DEAN')")
public class DeanController {

    private final AdministratorService administratorService;

    private final TechnicianService technicianService;

    private final ResidentDoctorService residentDoctorService;

    private final NurseService nurseService;

    private final SpecialistDoctorService specialistDoctorService;

    private final WorkingScheduleService workingScheduleService;

    private final CommonEmployeeService commonEmployeeService;

    private final ManagingInpatientService managingInpatientService;

    private final MedicationService medicationService;

    private final HospitalService hospitalService;

    private final InpatientService inpatientService;

    private final PatientMapper patientMapper;

    @Autowired
    public DeanController(AdministratorService administratorService,
                          TechnicianService technicianService,
                          ResidentDoctorService residentDoctorService,
                          NurseService nurseService,
                          SpecialistDoctorService specialistDoctorService,
                          WorkingScheduleService workingScheduleService,
                          CommonEmployeeService commonEmployeeService,
                          ManagingInpatientService managingInpatientService,
                          MedicationService medicationService,
                          HospitalService hospitalService,
                          InpatientService inpatientService,
                          PatientMapper patientMapper) {
        this.administratorService = administratorService;
        this.technicianService = technicianService;
        this.residentDoctorService = residentDoctorService;
        this.nurseService = nurseService;
        this.specialistDoctorService = specialistDoctorService;
        this.workingScheduleService = workingScheduleService;
        this.commonEmployeeService = commonEmployeeService;
        this.managingInpatientService = managingInpatientService;
        this.medicationService = medicationService;
        this.hospitalService = hospitalService;
        this.inpatientService = inpatientService;
        this.patientMapper = patientMapper;
    }

    @DeleteMapping("/delete-employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        commonEmployeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/get-patient-in-department/{department}")
    public List<PatientDTO> getAllPatientInDepartment(@PathVariable String department) {
        return patientMapper.mapToPatientDTOList(inpatientService.getAllPatientByDepartment(department));
    }

    @GetMapping("/show-department-employees/{department}")
    public List<Employee> showDepartmentEmployees(@PathVariable String department) {
        return commonEmployeeService.getAllEmployeesByDepartment(department);
    }

    @PostMapping("/insert-resident-doctor")
    public ResponseEntity<String> insertResidentDoctor(@RequestBody ResidentDoctor residentDoctor) {
        residentDoctorService.createEmployee(residentDoctor);
        return ResponseEntity.ok("Insert resident doctor successfully");
    }

    @PostMapping("/insert-specialist-doctor")
    public ResponseEntity<String> insertSpecialistDoctor(@RequestBody SpecialistDoctor specialistDoctor) {
        specialistDoctorService.createEmployee(specialistDoctor);
        return ResponseEntity.ok("Insert specialist doctor successfully");
    }

    @PostMapping("/insert-technician")
    public ResponseEntity<String> insertTechnician(@RequestBody Technician technician) {
        technicianService.createEmployee(technician);
        return ResponseEntity.ok("Insert technician successfully");
    }

    @PostMapping("/insert-nurse")
    public ResponseEntity<String> insertNurse(@RequestBody Nurse nurse) {
        nurseService.createEmployee(nurse);
        return ResponseEntity.ok("Insert nurse successfully");
    }

    @PostMapping("/insert-administrator")
    public ResponseEntity<String> insertAdministrator(@RequestBody Administrator administrator) {
        administratorService.createEmployee(administrator);
        return ResponseEntity.ok("Insert administrator successfully");
    }

    @PutMapping("/insert-working-schedule")
    public ResponseEntity<String> insertWorkingSchedule(@RequestBody List<WorkingSchedule> workingScheduleList) {
        workingScheduleService.initWorkingScheduleList(workingScheduleList);
        return ResponseEntity.ok("Insert working schedule successfully");
    }

    @DeleteMapping("/delete-working-schedule/{employeeId}")
    public ResponseEntity<String> deleteWorkingScheduleForEmployee(@PathVariable Long employeeId) {
        workingScheduleService.deleteWorkingSchedule(employeeId);
        return ResponseEntity.ok("Delete working schedule successfully");
    }

    @PutMapping("/assign-doctor-for-inpatient/{doctorId}/{patientId}")
    public ResponseEntity<String> assignManagingDoctorForPatient(@PathVariable Long doctorId,
                                                              @PathVariable Long patientId) {
        managingInpatientService.assignDoctorForPatient(doctorId, patientId);
        return ResponseEntity.ok("Set doctor successfully");
    }

    @PutMapping("/set-nurse-for-patient/{nurseId}/{patientId}")
    public ResponseEntity<String> setManagingNurseForPatient(@PathVariable Long nurseId,
                                                             @PathVariable Long patientId) {
        managingInpatientService.assignNurseForPatient(nurseId, patientId);
        return ResponseEntity.ok("Set nurse successfully");
    }

    @PostMapping("/import-medication")
    public ResponseEntity<String> importMedication(@RequestBody Medication medication) {
        medicationService.importMedication(medication);
        return ResponseEntity.ok("insert successfully.");
    }

    @PostMapping("/import-service")
    public ResponseEntity<String> importService(@RequestBody HospitalServiceEntity hospitalServiceEntity) {
        hospitalService.importHospitalFeeService(hospitalServiceEntity);
        return ResponseEntity.ok("insert successfully.");
    }

    @PutMapping("/update-medication/{medicationId}")
    public ResponseEntity<String> updateMedication(@RequestBody Medication medication, @PathVariable Long medicationId) {
        medicationService.updateMedication(medicationId, medication);
        return ResponseEntity.ok("update successfully.");
    }

    @PutMapping("/update-service/{serviceId}")
    public ResponseEntity<String> updateService(@RequestBody HospitalServiceEntity hospitalServiceEntity, @PathVariable Long serviceId) {
        hospitalService.updateHospitalService(serviceId, hospitalServiceEntity);
        return ResponseEntity.ok("update successfully.");
    }

    @DeleteMapping("/delete-medication/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long medicationId) {
        medicationService.deleteMedication(medicationId);
        return ResponseEntity.ok("delete successfully.");
    }

    @DeleteMapping("/delete-service/{serviceId}")
    public ResponseEntity<String> deleteService(@PathVariable Long serviceId) {
        hospitalService.deleteHospitalService(serviceId);
        return ResponseEntity.ok("delete successfully.");
    }

}
