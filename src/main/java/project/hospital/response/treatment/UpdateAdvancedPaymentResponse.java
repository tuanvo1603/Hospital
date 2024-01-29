package project.hospital.response.treatment;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class UpdateAdvancedPaymentResponse extends ResponseData {

    public UpdateAdvancedPaymentResponse() {
        super(StatusCode.SUCCESS.getCode(), "Update advanced payment successfully.");
    }

    public UpdateAdvancedPaymentResponse(int code, String message) {
        super(code, message);
    }
}
