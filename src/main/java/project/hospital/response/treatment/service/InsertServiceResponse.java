package project.hospital.response.treatment.service;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertServiceResponse extends ResponseData {

    public InsertServiceResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert service successfully.");
    }

    public InsertServiceResponse(int code, String message) {
        super(code, message);
    }
}
