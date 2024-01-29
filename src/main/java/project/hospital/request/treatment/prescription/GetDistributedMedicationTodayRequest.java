package project.hospital.request.treatment.prescription;

import project.hospital.request.RequestData;

public class GetDistributedMedicationTodayRequest extends RequestData {

    private Long employeeId;

    private Long patientId;

    public GetDistributedMedicationTodayRequest(Long employeeId, Long patientId) {
        this.employeeId = employeeId;
        this.patientId = patientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
