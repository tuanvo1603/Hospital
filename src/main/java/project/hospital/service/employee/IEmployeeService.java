package project.hospital.service.employee;

import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Employee;

public interface IEmployeeService <T extends Employee> {

    T createEmployee(T t);

    void updateEmployee(Long employeeId, T t);

    T getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    void checkExistenceOfEmployee(Long employeeId);
}
