package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
