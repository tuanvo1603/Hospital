package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Outpatient;

@Repository
public interface OutpatientRepository extends JpaRepository<Outpatient, Long> {
}
