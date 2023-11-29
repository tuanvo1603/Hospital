package project.hospital.controller.employee.doctor.dean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.service.employee.doctor.DeanService;

import java.util.ArrayList;

@RestController
@RequestMapping("/dean/internal-working")
public class DeanController {

    private final DeanService deanService;

    @Autowired
    public DeanController(DeanService deanService) {
        this.deanService = deanService;
    }

    @PostMapping("/insert-working-schedule")
    public void insertWorkingSchedule(@RequestBody ArrayList<WorkingSchedule> workingScheduleList) {
        deanService.insertWorkingSchedule(workingScheduleList);
    }

    @PostMapping("update-working-schedule")
    public void updateWorkingSchedule(@RequestBody ArrayList<WorkingSchedule> workingScheduleList) {
        deanService.updateWorkingSchedule(workingScheduleList);
    }
}
