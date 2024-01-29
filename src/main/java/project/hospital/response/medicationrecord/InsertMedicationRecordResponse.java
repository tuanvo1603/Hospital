package project.hospital.response.medicationrecord;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertMedicationRecordResponse extends ResponseData {

    public InsertMedicationRecordResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert medication record successfully.");
    }

    public InsertMedicationRecordResponse(int code, String message) {
        super(code, message);
    }
}
