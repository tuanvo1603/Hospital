package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByCitizenId(String citizenId);

    Patient findPatientByCitizenId(String citizenId);

    List<Patient> findPatientByFirstNameAndLastName(String firstName, String lastName);
}
