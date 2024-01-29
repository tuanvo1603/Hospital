package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.model.employee.Employee;
import project.hospital.request.employee.GetAllEmployeesInDepartmentRequest;
import project.hospital.response.employee.GetAllEmployeesInDepartmentResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.CommonEmployeeService;

import java.util.List;

@Component
public class GetAllEmployeesInDepartmentApi extends Api<GetAllEmployeesInDepartmentRequest, GetAllEmployeesInDepartmentResponse> {

    private final CommonEmployeeService commonEmployeeService;

    public GetAllEmployeesInDepartmentApi(SessionService sessionService, CommonEmployeeService commonEmployeeService) {
        super(sessionService);
        this.commonEmployeeService = commonEmployeeService;
    }


    @Override
    public GetAllEmployeesInDepartmentResponse execute(GetAllEmployeesInDepartmentRequest requestData) {
        try{
            List<Employee> employeeList = commonEmployeeService.getAllEmployeesByDepartment(requestData.getDepartment());

            return new GetAllEmployeesInDepartmentResponse(employeeList);
        }catch (Exception e) {
            return new GetAllEmployeesInDepartmentResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
