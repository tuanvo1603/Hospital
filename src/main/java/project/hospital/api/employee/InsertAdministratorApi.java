package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.InsertAdministratorRequest;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.AdministratorService;

@Component
public class InsertAdministratorApi extends Api<InsertAdministratorRequest, InsertEmployeeResponse> {

    private final AdministratorService administratorService;

    public InsertAdministratorApi(SessionService sessionService,
                                  AdministratorService administratorService) {
        super(sessionService);
        this.administratorService = administratorService;
    }

    @Override
    public InsertEmployeeResponse execute(InsertAdministratorRequest requestData) {
        try{
            administratorService.createEmployee(requestData.getAdministrator());

            return new InsertEmployeeResponse();
        }catch (Exception e) {
            return new InsertEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
