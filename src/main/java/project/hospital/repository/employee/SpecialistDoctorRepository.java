package project.hospital.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.employee.doctor.SpecialistDoctor;

@Repository
public interface SpecialistDoctorRepository extends JpaRepository<SpecialistDoctor, Long> {
}
