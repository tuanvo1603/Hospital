package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface InpatientRepository extends JpaRepository<Inpatient, Long> {

    List<Patient> findAllByDepartment(String department);
}
