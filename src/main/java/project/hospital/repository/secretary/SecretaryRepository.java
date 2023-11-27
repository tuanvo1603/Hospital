package project.hospital.repository.secretary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Employee;

@Repository
public interface SecretaryRepository extends JpaRepository<Employee, String> {
}
