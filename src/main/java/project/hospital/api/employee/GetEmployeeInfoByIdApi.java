package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Employee;
import project.hospital.request.employee.GetEmployeeInfoByIdRequest;
import project.hospital.response.employee.GetEmployeeInfoByIdResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.CommonEmployeeService;

@Component
public class GetEmployeeInfoByIdApi extends Api<GetEmployeeInfoByIdRequest, GetEmployeeInfoByIdResponse> {

    private final CommonEmployeeService commonEmployeeService;

    public GetEmployeeInfoByIdApi(CommonEmployeeService commonEmployeeService, SessionService sessionService) {
        super(sessionService);
        this.commonEmployeeService = commonEmployeeService;
    }

    @Override
    public GetEmployeeInfoByIdResponse execute(GetEmployeeInfoByIdRequest requestData) {
        try{
            Employee employee = commonEmployeeService.getEmployeeById(requestData.getEmployeeId());

            return new GetEmployeeInfoByIdResponse(employee);
        }catch (EmployeeNotFoundException e) {
            return new GetEmployeeInfoByIdResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new GetEmployeeInfoByIdResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
