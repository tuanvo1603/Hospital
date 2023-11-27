package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
