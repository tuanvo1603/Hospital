package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.doctor.ResidentDoctor;

@Repository
public interface ResidentDoctorRepository extends JpaRepository<ResidentDoctor, Long> {
}
