package project.hospital.request.workingschedule;

import project.hospital.request.RequestData;

public class DeleteWorkingScheduleRequest extends RequestData {

    private Long employeeId;

    public DeleteWorkingScheduleRequest(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
