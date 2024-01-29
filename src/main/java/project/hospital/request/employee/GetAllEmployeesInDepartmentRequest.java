package project.hospital.request.employee;

import project.hospital.request.RequestData;

public class GetAllEmployeesInDepartmentRequest extends RequestData {

    private String department;

    public GetAllEmployeesInDepartmentRequest(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
