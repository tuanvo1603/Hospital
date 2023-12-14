package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.service.employee.InternalWorkingService;

@RestController
@RequestMapping("/employee-internal-working")
public class InternalWorkingController {
    /**
     * Done
     */
    private final InternalWorkingService internalWorkingService;

    @Autowired
    public InternalWorkingController(InternalWorkingService internalWorkingService) {
        this.internalWorkingService = internalWorkingService;
    }

    @GetMapping("/check-schedule/{employeeId}")
    public WorkingSchedule checkWorkingSchedule(@PathVariable Long employeeId) {
        return internalWorkingService.checkWorkingSchedule(employeeId);
    }

    @GetMapping("/check-my-information/{employeeId}")
    public Employee checkMyInformation(@PathVariable Long employeeId) {
        return internalWorkingService.checkMyInformation(employeeId);
    }
}
