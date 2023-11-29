package project.hospital.repository.patient;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Outpatient " +
                    "WHERE patient_id = :patientId",
            nativeQuery = true)
    void deleteOutpatient(@Param("patientId") String patientId);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Inpatient(patient_id, department, bed_cell, room) " +
                    "VALUES (:patientId, :department, :bedCell, :room)",
            nativeQuery = true)
    void insertInpatient(@Param("patientId") String patientId,
                         @Param("department") String department,
                         @Param("bedCell") Integer bedCell,
                         @Param("room") String room);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE Inpatient " +
                    "SET department = :department " +
                    "WHERE patient_id = :patientId",
            nativeQuery = true)
    void changePatientDepartment(@Param("department") String department,
                                 @Param("patientId") String patientId);

}
