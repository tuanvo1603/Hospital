package project.hospital.api.workingschedule;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.workingschedule.DeleteWorkingScheduleRequest;
import project.hospital.response.workingschedule.DeleteWorkingScheduleResponse;
import project.hospital.service.SessionService;
import project.hospital.service.schedule.WorkingScheduleService;

@Component
public class DeleteWorkingScheduleApi extends Api<DeleteWorkingScheduleRequest, DeleteWorkingScheduleResponse> {

    private final WorkingScheduleService workingScheduleService;

    public DeleteWorkingScheduleApi(SessionService sessionService, WorkingScheduleService workingScheduleService) {
        super(sessionService);
        this.workingScheduleService = workingScheduleService;
    }

    @Override
    public DeleteWorkingScheduleResponse execute(DeleteWorkingScheduleRequest requestData) {
        try{
            workingScheduleService.deleteWorkingSchedule(requestData.getEmployeeId());
            return new DeleteWorkingScheduleResponse();
        }catch (Exception e) {
            return new DeleteWorkingScheduleResponse(StatusCode.UNKNOWN.getCode(), "Error in process.");
        }
    }
}
