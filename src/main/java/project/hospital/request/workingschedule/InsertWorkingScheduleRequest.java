package project.hospital.request.workingschedule;

import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.request.RequestData;

import java.util.List;

public class InsertWorkingScheduleRequest extends RequestData {

    private WorkingSchedule workingSchedule;

    public InsertWorkingScheduleRequest(WorkingSchedule workingSchedule) {
        this.workingSchedule = workingSchedule;
    }

    public WorkingSchedule getWorkingSchedule() {
        return workingSchedule;
    }

    public void setWorkingSchedule(WorkingSchedule workingSchedule) {
        this.workingSchedule = workingSchedule;
    }
}
