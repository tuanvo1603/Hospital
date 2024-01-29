package project.hospital.response.employee;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertEmployeeResponse extends ResponseData {

    public InsertEmployeeResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert employee successfully.");
    }

    public InsertEmployeeResponse(int code, String message) {
        super(code, message);
    }
}
