package project.hospital.response.patient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class DischargePatientResponse extends ResponseData {

    public DischargePatientResponse() {
        super(StatusCode.SUCCESS.getCode(), "Discharge patient successfully.");
    }

    public DischargePatientResponse(int code, String message) {
        super(code, message);
    }
}
