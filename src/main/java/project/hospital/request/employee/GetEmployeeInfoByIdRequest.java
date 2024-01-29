package project.hospital.request.employee;

import project.hospital.request.RequestData;

public class GetEmployeeInfoByIdRequest extends RequestData {

    private Long employeeId;

    public GetEmployeeInfoByIdRequest(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
