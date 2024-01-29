package project.hospital.response.treatment.medication;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class DeleteMedicationResponse extends ResponseData {

    public DeleteMedicationResponse() {
        super(StatusCode.SUCCESS.getCode(), "Delete medication successfully.");
    }

    public DeleteMedicationResponse(int code, String message) {
        super(code, message);
    }
}
