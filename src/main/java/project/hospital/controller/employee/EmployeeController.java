package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.employee.GetEmployeeInfoApi;
import project.hospital.api.workingschedule.GetWorkingScheduleInfoApi;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;

@RestController
@RequestMapping("/employee")
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeController {

    private final GetEmployeeInfoApi getEmployeeInfoApi;

    private final GetWorkingScheduleInfoApi getWorkingScheduleInfoApi;

    public EmployeeController(GetEmployeeInfoApi getEmployeeInfoApi, GetWorkingScheduleInfoApi getWorkingScheduleInfoApi) {
        this.getEmployeeInfoApi = getEmployeeInfoApi;
        this.getWorkingScheduleInfoApi = getWorkingScheduleInfoApi;
    }


    @GetMapping("/check-schedule/{employeeId}")
    public WorkingSchedule checkWorkingSchedule(@PathVariable Long employeeId) {
        return getWorkingScheduleInfoApi.getWorkingSchedule(employeeId);
    }

    @GetMapping("/check-my-information/{employeeId}")
    public Employee checkMyInformation(@PathVariable Long employeeId) {
        return getEmployeeInfoApi.getEmployeeInfo(employeeId);
    }
}
