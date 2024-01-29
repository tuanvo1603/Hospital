package project.hospital.response.treatment.medication;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertMedicationResponse extends ResponseData {

    public InsertMedicationResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert medication successfully.");
    }

    public InsertMedicationResponse(int code, String message) {
        super(code, message);
    }
}
