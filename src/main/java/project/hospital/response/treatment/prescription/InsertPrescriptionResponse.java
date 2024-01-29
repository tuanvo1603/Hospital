package project.hospital.response.treatment.prescription;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertPrescriptionResponse extends ResponseData {

    public InsertPrescriptionResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert prescription successfully.");
    }

    public InsertPrescriptionResponse(int code, String message) {
        super(code, message);
    }
}
