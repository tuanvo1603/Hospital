package project.hospital.response.medicationrecord;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.response.ResponseData;

@ResponseBody
public class GetMedicationRecordByCitizenIdResponse extends ResponseData {

    private MedicationRecord medicationRecord;

    public GetMedicationRecordByCitizenIdResponse(int code, String message) {
        super(code, message);
    }

    public GetMedicationRecordByCitizenIdResponse(MedicationRecord medicationRecord) {
        this.medicationRecord = medicationRecord;
    }

    public MedicationRecord getMedicationRecord() {
        return medicationRecord;
    }

    public void setMedicationRecord(MedicationRecord medicationRecord) {
        this.medicationRecord = medicationRecord;
    }
}
