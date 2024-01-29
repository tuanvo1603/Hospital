package project.hospital.response.treatment.medication;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class UpdateMedicationResponse extends ResponseData {

    public UpdateMedicationResponse() {
        super(StatusCode.SUCCESS.getCode(), "Update medication successfully.");
    }

    public UpdateMedicationResponse(int code, String message) {
        super(code, message);
    }
}
