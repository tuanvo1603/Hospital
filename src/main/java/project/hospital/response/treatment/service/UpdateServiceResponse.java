package project.hospital.response.treatment.service;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class UpdateServiceResponse extends ResponseData {

    public UpdateServiceResponse() {
        super(StatusCode.SUCCESS.getCode(), "Update service successfully.");
    }

    public UpdateServiceResponse(int code, String message) {
        super(code, message);
    }
}
