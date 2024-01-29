package project.hospital.request.treatment;

import project.hospital.model.treatment.Treatment;
import project.hospital.request.RequestData;

public class InsertTreatmentRequest extends RequestData {

    private Long doctorId;

    private Long patientId;

    private Treatment treatment;

    public InsertTreatmentRequest(Long doctorId, Long patientId, Treatment treatment) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.treatment = treatment;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
