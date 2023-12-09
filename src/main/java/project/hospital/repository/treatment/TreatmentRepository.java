package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, String> {
}
