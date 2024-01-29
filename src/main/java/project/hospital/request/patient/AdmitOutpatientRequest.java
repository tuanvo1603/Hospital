package project.hospital.request.patient;

import project.hospital.model.patient.Outpatient;
import project.hospital.request.RequestData;

public class AdmitOutpatientRequest extends RequestData {

    private Long administratorId;

    private Outpatient outpatient;

    public AdmitOutpatientRequest(Long administratorId, Outpatient outpatient) {
        this.administratorId = administratorId;
        this.outpatient = outpatient;
    }

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }

    public Outpatient getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Outpatient outpatient) {
        this.outpatient = outpatient;
    }
}
