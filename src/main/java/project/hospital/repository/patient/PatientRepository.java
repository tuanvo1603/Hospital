package project.hospital.repository.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Patient;

@Repository
@Qualifier("PatientRepository")
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Modifying
    @Query(value = "DELETE FROM Outpatient WHERE patient_id = :patientId", nativeQuery = true)
    void deleteOutpatient(@Param("patientId") String patientId);

    @Modifying
    @Query(value = "INSERT INTO Inpatient(patient_id, department, bed_cell, room)"
            + " VALUES (:patientId, :department, :bedCell, :room)", nativeQuery = true)
    void insertInpatient(@Param("patientId") String patientId, @Param("department") String department, @Param("bedCell") Integer bedCell, @Param("room") String room);
}
