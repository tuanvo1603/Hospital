package project.hospital.response.workingschedule;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class InsertWorkingScheduleResponse extends ResponseData {

    public InsertWorkingScheduleResponse() {
        super(StatusCode.SUCCESS.getCode(), "Insert working schedule successfully.");
    }

    public InsertWorkingScheduleResponse(int code, String message) {
        super(code, message);
    }
}
