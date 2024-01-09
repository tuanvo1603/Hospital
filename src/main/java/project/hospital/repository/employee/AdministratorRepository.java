package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
