package project.hospital.response.managingpatient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.constant.StatusCode;
import project.hospital.response.ResponseData;

@ResponseBody
public class AssignDoctorForPatientResponse extends ResponseData {

    public AssignDoctorForPatientResponse(String message) {
        super(StatusCode.SUCCESS.getCode(), message);
    }

    public AssignDoctorForPatientResponse(int code, String message) {
        super(code, message);
    }
}
