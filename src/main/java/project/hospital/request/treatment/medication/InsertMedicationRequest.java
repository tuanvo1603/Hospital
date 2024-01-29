package project.hospital.request.treatment.medication;

import project.hospital.model.treatment.medication.Medication;
import project.hospital.request.RequestData;

public class InsertMedicationRequest extends RequestData {

    private Medication medication;

    public InsertMedicationRequest(Medication medication) {
        this.medication = medication;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
