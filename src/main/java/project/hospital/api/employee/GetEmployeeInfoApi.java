package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.model.employee.Employee;
import project.hospital.service.employee.CommonEmployeeService;

@Component
public class GetEmployeeInfoApi {

    private final CommonEmployeeService commonEmployeeService;

    public GetEmployeeInfoApi(CommonEmployeeService commonEmployeeService) {
        this.commonEmployeeService = commonEmployeeService;
    }

    public Employee getEmployeeInfo(Long employeeId) {
        return commonEmployeeService.getEmployeeById(employeeId);
    }
}
