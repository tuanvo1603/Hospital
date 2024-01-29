package project.hospital.request.treatment.medication;

import project.hospital.request.RequestData;

public class DeleteMedicationRequest extends RequestData {

    private Long medicationId;

    public DeleteMedicationRequest(Long medicationId) {
        this.medicationId = medicationId;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }
}
