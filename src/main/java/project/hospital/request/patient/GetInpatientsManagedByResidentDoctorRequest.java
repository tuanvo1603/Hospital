package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class GetInpatientsManagedByResidentDoctorRequest extends RequestData {

    private Long employeeId;

    public GetInpatientsManagedByResidentDoctorRequest(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
