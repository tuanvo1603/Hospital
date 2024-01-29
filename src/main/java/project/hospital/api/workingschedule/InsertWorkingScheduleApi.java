package project.hospital.api.workingschedule;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.request.workingschedule.InsertWorkingScheduleRequest;
import project.hospital.response.workingschedule.InsertWorkingScheduleResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.schedule.WorkingScheduleService;

@Component
public class InsertWorkingScheduleApi extends Api<InsertWorkingScheduleRequest, InsertWorkingScheduleResponse> {

    private final WorkingScheduleService workingScheduleService;

    private final CommonEmployeeService commonEmployeeService;

    public InsertWorkingScheduleApi(SessionService sessionService,
                                    WorkingScheduleService workingScheduleService,
                                    CommonEmployeeService commonEmployeeService) {
        super(sessionService);
        this.workingScheduleService = workingScheduleService;
        this.commonEmployeeService = commonEmployeeService;
    }

    @Override
    public InsertWorkingScheduleResponse execute(InsertWorkingScheduleRequest requestData) {
        try {
            WorkingSchedule workingSchedule = requestData.getWorkingSchedule();
            commonEmployeeService.checkExistenceOfEmployee(workingSchedule.getWorkingScheduleId().getEmployeeId());
            workingScheduleService.initWorkingSchedule(workingSchedule);
            return new InsertWorkingScheduleResponse();
        }catch (EmployeeNotFoundException e) {
            return new InsertWorkingScheduleResponse(StatusCode.REQUEST.getCode(), "Employee Id is not valid.");
        }catch (Exception e) {
            return new InsertWorkingScheduleResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
