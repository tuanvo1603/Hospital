package project.hospital.request.treatment;

import project.hospital.request.RequestData;

public class GetHospitalFeeRequest extends RequestData {

    private Long patientId;

    public GetHospitalFeeRequest(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
