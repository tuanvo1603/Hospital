package project.hospital.api.treatment.medication;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.service.treatment.prescription.MedicationService;

import java.util.List;

@Component
public class GetMedicationListApi {

    private final MedicationService medicationService;

    public GetMedicationListApi(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    public List<Medication> getMedicationList() {
        return medicationService.getMedicationList();
    }
}
