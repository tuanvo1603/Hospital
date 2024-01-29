package project.hospital.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ResponseData {

    private int code;

    private String message;

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
