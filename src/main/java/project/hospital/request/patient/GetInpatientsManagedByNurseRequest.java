package project.hospital.request.patient;

import project.hospital.request.RequestData;

public class GetInpatientsManagedByNurseRequest extends RequestData {

    private Long nurseId;

    public GetInpatientsManagedByNurseRequest(Long nurseId) {
        this.nurseId = nurseId;
    }

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }
}
