package project.hospital.response.patient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class AdmitOutpatientResponse extends ResponseData {

    public AdmitOutpatientResponse() {
        super(StatusCode.SUCCESS.getCode(), "Admit outpatient successfully.");
    }

    public AdmitOutpatientResponse(int code, String message) {
        super(code, message);
    }
}
