package project.hospital.controller.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.service.employee.doctor.dean.DeanService;

import java.util.List;

@RestController
@RequestMapping("/dean/internal-working")
public class ManagingWorkingController {
    /**
     * Done
     */
    private final DeanService deanService;

    @Autowired
    public ManagingWorkingController(DeanService deanService) {
        this.deanService = deanService;
    }

    @PostMapping("/insert-working-schedule")
    public void insertWorkingSchedule(@RequestBody List<WorkingSchedule> workingScheduleList) {
        deanService.insertWorkingSchedule(workingScheduleList);
    }

    @PostMapping("/delete-working-schedule/{employeeId}")
    public void deleteWorkingScheduleForEmployee(@PathVariable Long employeeId) {
        deanService.deleteWorkingScheduleForEmployee(employeeId);
    }

    @PutMapping("/set-doctor-for-patient/{doctorId}/{patientId}")
    public void setManagingDoctorForPatient(@PathVariable Long doctorId,
                                            @PathVariable Long patientId) throws PatientCanNotBeFoundException {
        deanService.setManagingDoctorForPatient(doctorId, patientId);
    }

}
