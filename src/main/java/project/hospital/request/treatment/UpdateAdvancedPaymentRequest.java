package project.hospital.request.treatment;

import project.hospital.request.RequestData;

public class UpdateAdvancedPaymentRequest extends RequestData {

    private Long employeeId;

    private Long patientId;

    private Integer advancedPayment;

    public UpdateAdvancedPaymentRequest(Long employeeId, Long patientId, Integer advancedPayment) {
        this.employeeId = employeeId;
        this.patientId = patientId;
        this.advancedPayment = advancedPayment;
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

    public Integer getAdvancedPayment() {
        return advancedPayment;
    }

    public void setAdvancedPayment(Integer advancedPayment) {
        this.advancedPayment = advancedPayment;
    }
}
