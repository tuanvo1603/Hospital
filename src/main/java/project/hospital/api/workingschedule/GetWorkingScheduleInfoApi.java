package project.hospital.api.workingschedule;

import org.springframework.stereotype.Component;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.service.schedule.WorkingScheduleService;

@Component
public class GetWorkingScheduleInfoApi {

    private final WorkingScheduleService workingScheduleService;

    public GetWorkingScheduleInfoApi(WorkingScheduleService workingScheduleService) {
        this.workingScheduleService = workingScheduleService;
    }

    public WorkingSchedule getWorkingSchedule(Long employeeId) {
        return workingScheduleService.getCurrentWeekWorkingSchedule(employeeId);
    }
}
