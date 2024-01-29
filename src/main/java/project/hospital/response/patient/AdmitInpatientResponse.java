package project.hospital.response.patient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class AdmitInpatientResponse extends ResponseData {

    public AdmitInpatientResponse() {
        super(StatusCode.SUCCESS.getCode(), "Admit inpatient successfully.");
    }

    public AdmitInpatientResponse(int code, String message) {
        super(code, message);
    }
}
