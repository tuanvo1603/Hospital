package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
