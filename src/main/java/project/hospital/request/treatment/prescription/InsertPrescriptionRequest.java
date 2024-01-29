package project.hospital.request.treatment.prescription;

import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.request.RequestData;

public class InsertPrescriptionRequest extends RequestData {

    private Long doctorId;

    private Long patientId;

    private PrescriptionDetail prescriptionDetail;

    public InsertPrescriptionRequest(Long doctorId, Long patientId, PrescriptionDetail prescriptionDetail) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.prescriptionDetail = prescriptionDetail;
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

    public PrescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public void setPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }
}
