package project.hospital.api.medicationrecord;

import org.springframework.stereotype.Component;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.service.medicationrecord.MedicationRecordService;

@Component
public class GetMedicationRecordApi {

    private final MedicationRecordService medicationRecordService;


    public GetMedicationRecordApi(MedicationRecordService medicationRecordService) {
        this.medicationRecordService = medicationRecordService;
    }

    public MedicationRecord getMedicationRecord(String citizenId) {
        return medicationRecordService.getMedicationRecordById(citizenId);
    }
}
