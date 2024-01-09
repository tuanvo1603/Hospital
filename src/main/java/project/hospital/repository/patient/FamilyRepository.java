package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
}
