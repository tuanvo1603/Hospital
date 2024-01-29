package project.hospital.request.treatment.medication;

import project.hospital.model.treatment.medication.Medication;
import project.hospital.request.RequestData;

public class UpdateMedicationRequest extends RequestData {

    private Long medicationId;

    private Medication medication;

    public UpdateMedicationRequest(Long medicationId, Medication medication) {
        this.medicationId = medicationId;
        this.medication = medication;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
