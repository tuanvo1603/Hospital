package project.hospital.request.medicationrecord;

import project.hospital.request.RequestData;

public class InsertMedicationRecordRequest extends RequestData {

    private Long doctorId;

    private String citizenId;

    private String description;

    public InsertMedicationRecordRequest(Long doctorId, String citizenId, String description) {
        this.doctorId = doctorId;
        this.citizenId = citizenId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
