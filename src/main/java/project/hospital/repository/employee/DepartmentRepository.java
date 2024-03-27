package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
