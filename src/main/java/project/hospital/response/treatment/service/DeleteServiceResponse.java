package project.hospital.response.treatment.service;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class DeleteServiceResponse extends ResponseData {

    public DeleteServiceResponse() {
        super(StatusCode.SUCCESS.getCode(), "Delete service successfully.");
    }

    public DeleteServiceResponse(int code, String message) {
        super(code, message);
    }
}
