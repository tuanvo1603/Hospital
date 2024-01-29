package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.InsertTechnicianRequest;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.TechnicianService;

@Component
public class InsertTechnicianApi extends Api<InsertTechnicianRequest, InsertEmployeeResponse> {

    private final TechnicianService technicianService;

    public InsertTechnicianApi(SessionService sessionService, TechnicianService technicianService) {
        super(sessionService);
        this.technicianService = technicianService;
    }

    @Override
    public InsertEmployeeResponse execute(InsertTechnicianRequest requestData) {
        try{
            technicianService.createEmployee(requestData.getTechnician());

            return new InsertEmployeeResponse();
        }catch (Exception e){
            return new InsertEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
