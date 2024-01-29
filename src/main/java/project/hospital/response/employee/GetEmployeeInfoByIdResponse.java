package project.hospital.response.employee;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.employee.Employee;
import project.hospital.response.ResponseData;

@ResponseBody
public class GetEmployeeInfoByIdResponse extends ResponseData {

    private Employee employee;

    public GetEmployeeInfoByIdResponse(Employee employee) {
        this.employee = employee;
    }

    public GetEmployeeInfoByIdResponse(int code, String message) {
        super(code, message);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
