package project.hospital.repository.patient;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Patient p " +
            "WHERE p.patientId = :patientId")
    void deletePatient(@Param("patientId") Long patientId);
}
