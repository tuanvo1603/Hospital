package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class DischargePatientRequest extends RequestData {

    private Long administratorId;

    private Long patientId;

    public DischargePatientRequest(Long administratorId, Long patientId) {
        this.administratorId = administratorId;
        this.patientId = patientId;
    }

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
