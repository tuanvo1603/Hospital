package project.hospital.api.employee;

import org.springframework.stereotype.Controller;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.InsertNurseRequest;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.NurseService;

@Controller
public class InsertNurseApi extends Api<InsertNurseRequest, InsertEmployeeResponse> {

    private final NurseService nurseService;

    public InsertNurseApi(SessionService sessionService, NurseService nurseService) {
        super(sessionService);
        this.nurseService = nurseService;
    }

    @Override
    public InsertEmployeeResponse execute(InsertNurseRequest requestData) {
        try{
            nurseService.createEmployee(requestData.getNurse());

            return new InsertEmployeeResponse();
        }catch (Exception e) {
            return new InsertEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
