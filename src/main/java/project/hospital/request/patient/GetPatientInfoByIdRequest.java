package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class GetPatientInfoByIdRequest extends RequestData {

    private Long patientId;

    public GetPatientInfoByIdRequest(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
