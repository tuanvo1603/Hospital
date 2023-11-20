package project.hospital.repository.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.Patient;

@Repository
@Qualifier("PatientRepository")
public interface PatientRepository extends JpaRepository<Patient, String> {
}
