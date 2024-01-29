package project.hospital.response.employee;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class DeleteEmployeeResponse extends ResponseData {

    public DeleteEmployeeResponse() {
        super(StatusCode.SUCCESS.getCode(), "Delete employee successfully.");
    }

    public DeleteEmployeeResponse(int code, String message) {
        super(code, message);
    }
}
