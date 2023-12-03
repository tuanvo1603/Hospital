package project.hospital.controller.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.service.employee.doctor.dean.DeanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dean/internal-working")
public class DeanController {
    /**
     * Done
     */
    private final DeanService deanService;

    @Autowired
    public DeanController(DeanService deanService) {
        this.deanService = deanService;
    }

    @PostMapping("/insert-working-schedule")
    public void insertWorkingSchedule(@RequestBody List<WorkingSchedule> workingScheduleList) {
        deanService.insertWorkingSchedule(workingScheduleList);
    }

    @PostMapping("/update-working-schedule")
    public void updateWorkingSchedule(@RequestBody List<WorkingSchedule> workingScheduleList) {
        deanService.updateWorkingSchedule(workingScheduleList);
    }

}
