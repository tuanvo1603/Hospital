package project.hospital.response.workingschedule;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class DeleteWorkingScheduleResponse extends ResponseData {

    public DeleteWorkingScheduleResponse() {
        super(StatusCode.SUCCESS.getCode(), "Delete working schedule successfully.");
    }

    public DeleteWorkingScheduleResponse(int code, String message) {
        super(code, message);
    }

}
