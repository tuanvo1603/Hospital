package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Inpatient;

@Repository
public interface InpatientRepository extends JpaRepository<Inpatient, String> {

}
