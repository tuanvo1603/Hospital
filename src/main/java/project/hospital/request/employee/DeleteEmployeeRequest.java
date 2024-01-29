package project.hospital.request.employee;

import project.hospital.request.RequestData;

public class DeleteEmployeeRequest extends RequestData {

    private Long employeeId;

    public DeleteEmployeeRequest(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
