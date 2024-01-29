package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class GetInpatientsTreatAtDepartmentRequest extends RequestData {

    private String department;

    public GetInpatientsTreatAtDepartmentRequest(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
