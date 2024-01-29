package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class AdmitInpatientRequest extends RequestData {

    private Long specialistDoctorId;

    private Long patientId;

    public AdmitInpatientRequest(Long specialistDoctorId, Long patientId) {
        this.specialistDoctorId = specialistDoctorId;
        this.patientId = patientId;
    }

    public Long getSpecialistDoctorId() {
        return specialistDoctorId;
    }

    public void setSpecialistDoctorId(Long specialistDoctorId) {
        this.specialistDoctorId = specialistDoctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
