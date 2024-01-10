package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.employee.GetEmployeeInfoApi;
import project.hospital.api.treatment.medication.GetMedicationListApi;
import project.hospital.api.treatment.service.GetServiceListApi;
import project.hospital.api.workingschedule.GetWorkingScheduleInfoApi;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.service.HospitalServiceEntity;

import java.util.List;

@RestController
@RequestMapping("/employee")
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeController {

    private final GetEmployeeInfoApi getEmployeeInfoApi;

    private final GetWorkingScheduleInfoApi getWorkingScheduleInfoApi;

    private final GetMedicationListApi getMedicationListApi;

    private final GetServiceListApi getServiceListApi;

    public EmployeeController(GetEmployeeInfoApi getEmployeeInfoApi,
                              GetWorkingScheduleInfoApi getWorkingScheduleInfoApi,
                              GetMedicationListApi getMedicationListApi,
                              GetServiceListApi getServiceListApi) {
        this.getEmployeeInfoApi = getEmployeeInfoApi;
        this.getWorkingScheduleInfoApi = getWorkingScheduleInfoApi;
        this.getMedicationListApi = getMedicationListApi;
        this.getServiceListApi = getServiceListApi;
    }


    @GetMapping("/check-schedule/{employeeId}")
    public WorkingSchedule checkWorkingSchedule(@PathVariable Long employeeId) {
        return getWorkingScheduleInfoApi.getWorkingSchedule(employeeId);
    }

    @GetMapping("/check-my-information/{employeeId}")
    public Employee checkMyInformation(@PathVariable Long employeeId) {
        return getEmployeeInfoApi.getEmployeeInfo(employeeId);
    }

    @GetMapping("/get-medication-list")
    public List<Medication> getMedicationList() {
        return getMedicationListApi.getMedicationList();
    }

    @GetMapping("/get-service-list")
    public List<HospitalServiceEntity> getServiceList() {
        return getServiceListApi.getServiceList();
    }
}
