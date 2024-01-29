package project.hospital.response.managingpatient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class AssignNurseForInpatientResponse extends ResponseData {

    public AssignNurseForInpatientResponse() {
        super(StatusCode.SUCCESS.getCode(), "Assign nurse for patient successfully.");
    }

    public AssignNurseForInpatientResponse(int code, String message) {
        super(code, message);
    }
}
