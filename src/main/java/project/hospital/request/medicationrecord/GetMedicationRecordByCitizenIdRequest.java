package project.hospital.request.medicationrecord;

import project.hospital.request.RequestData;

public class GetMedicationRecordByCitizenIdRequest extends RequestData {

    private Long doctorId;

    private String citizenId;

    public GetMedicationRecordByCitizenIdRequest(Long doctorId, String citizenId) {
        this.doctorId = doctorId;
        this.citizenId = citizenId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }
}
