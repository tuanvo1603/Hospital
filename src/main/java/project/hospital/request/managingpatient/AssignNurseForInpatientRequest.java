package project.hospital.request.managingpatient;

import project.hospital.request.RequestData;

public class AssignNurseForInpatientRequest extends RequestData {

    private Long nurseId;

    private Long patientId;

    public AssignNurseForInpatientRequest(Long nurseId, Long patientId) {
        this.nurseId = nurseId;
        this.patientId = patientId;
    }

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
