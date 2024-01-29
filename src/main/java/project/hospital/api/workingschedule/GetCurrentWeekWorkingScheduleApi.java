package project.hospital.api.workingschedule;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.BusinessException;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.request.workingschedule.GetCurrentWeekWorkingScheduleRequest;
import project.hospital.response.workingschedule.GetCurrentWeekWorkingScheduleResponse;
import project.hospital.service.SessionService;
import project.hospital.service.schedule.WorkingScheduleService;

@Component
public class GetCurrentWeekWorkingScheduleApi extends Api<GetCurrentWeekWorkingScheduleRequest, GetCurrentWeekWorkingScheduleResponse> {

    private final WorkingScheduleService workingScheduleService;

    public GetCurrentWeekWorkingScheduleApi(SessionService sessionService, WorkingScheduleService workingScheduleService) {
        super(sessionService);
        this.workingScheduleService = workingScheduleService;
    }

    @Override
    public GetCurrentWeekWorkingScheduleResponse execute(GetCurrentWeekWorkingScheduleRequest requestData) {
        try {
            Long employeeId = requestData.getEmployeeId();
            WorkingSchedule workingSchedule = workingScheduleService.getCurrentWeekWorkingSchedule(employeeId);
            if(workingSchedule == null) {
                throw new BusinessException(StatusCode.REQUEST.getCode(), "There is no working schedule of this employee.");
            }
            return new GetCurrentWeekWorkingScheduleResponse(workingSchedule);
        }catch (BusinessException e) {
            return new GetCurrentWeekWorkingScheduleResponse(e.getCode(), e.getMessage());
        }catch (Exception e) {
            return new GetCurrentWeekWorkingScheduleResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
