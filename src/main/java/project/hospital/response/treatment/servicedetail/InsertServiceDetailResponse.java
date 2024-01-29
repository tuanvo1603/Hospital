package project.hospital.response.treatment.servicedetail;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertServiceDetailResponse extends ResponseData {

    public InsertServiceDetailResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert service detail successfully.");
    }

    public InsertServiceDetailResponse(int code, String message) {
        super(code, message);
    }
}
