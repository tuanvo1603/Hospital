package project.hospital.response.treatment;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertTreatmentResponse extends ResponseData {

    public InsertTreatmentResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert treatment successfully.");
    }

    public InsertTreatmentResponse(int code, String message) {
        super(code, message);
    }
}
