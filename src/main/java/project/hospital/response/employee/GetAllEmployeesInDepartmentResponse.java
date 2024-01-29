package project.hospital.response.employee;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.employee.Employee;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetAllEmployeesInDepartmentResponse extends ResponseData {

    private List<Employee> employeeList;

    public GetAllEmployeesInDepartmentResponse(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public GetAllEmployeesInDepartmentResponse(int code, String message) {
        super(code, message);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
