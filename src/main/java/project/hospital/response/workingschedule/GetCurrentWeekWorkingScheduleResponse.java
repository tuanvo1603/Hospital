package project.hospital.response.workingschedule;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetCurrentWeekWorkingScheduleResponse extends ResponseData {

    private WorkingSchedule WorkingSchedule;

    public GetCurrentWeekWorkingScheduleResponse(WorkingSchedule WorkingSchedule) {
        this.WorkingSchedule = WorkingSchedule;
    }

    public GetCurrentWeekWorkingScheduleResponse(int code, String message) {
        super(code, message);
    }

    public WorkingSchedule getWorkingScheduleList() {
        return WorkingSchedule;
    }

    public void setWorkingScheduleList(WorkingSchedule WorkingSchedule) {
        this.WorkingSchedule = WorkingSchedule;
    }
}
