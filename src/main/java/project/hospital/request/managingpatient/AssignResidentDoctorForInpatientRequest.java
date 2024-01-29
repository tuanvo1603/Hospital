package project.hospital.request.managingpatient;

import project.hospital.request.RequestData;

public class AssignResidentDoctorForInpatientRequest extends RequestData {

    private Long doctorId;

    private Long patientId;

    public AssignResidentDoctorForInpatientRequest(Long doctorId, Long patientId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
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
}
