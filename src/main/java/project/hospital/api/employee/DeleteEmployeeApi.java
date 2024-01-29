package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.DeleteEmployeeRequest;
import project.hospital.response.employee.DeleteEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.CommonEmployeeService;

@Component
public class DeleteEmployeeApi extends Api<DeleteEmployeeRequest, DeleteEmployeeResponse> {

    private final CommonEmployeeService commonEmployeeService;

    public DeleteEmployeeApi(SessionService sessionService, CommonEmployeeService commonEmployeeService) {
        super(sessionService);
        this.commonEmployeeService = commonEmployeeService;
    }

    @Override
    public DeleteEmployeeResponse execute(DeleteEmployeeRequest requestData) {
        try {
            commonEmployeeService.deleteEmployee(requestData.getEmployeeId());

            return new DeleteEmployeeResponse();
        }catch (Exception e) {
            return new DeleteEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
