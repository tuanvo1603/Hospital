package project.hospital.repository.patient;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface InpatientRepository extends JpaRepository<Inpatient, Long> {
    @Query("SELECT p " +
            "FROM Inpatient p " +
            "WHERE p.department = :department " +
            "AND p.firstName = :patientFirstName"
    )
    List<Patient> searchPatientByDepartment(
            @Param("patientFirstName") String patientFirstName,
            @Param("department") String department
    );

    @Query("SELECT p " +
            "FROM Patient p " +
            "WHERE p.firstName = :patientFirstName " +
            "AND p.lastName = :patientLastName"
    ) List<Patient> searchPatientByFullName(
            @Param("patientFirstName") String patientFirstName,
            @Param("patientLastName") String patientLastName
    );

//    @Modifying
//    @Transactional
//    @Query(
//            value = "INSERT INTO Inpatient(patient_id, department, bed_cell, room) " +
//            "VALUES (:patientId, :department, :bedCell, :room)",
//            nativeQuery = true
//    ) void insertInpatient(@Param("patientId") Long patientId,
//                           @Param("department") String department,
//                           @Param("bedCell") Integer bedCell,
//                           @Param("room") String room);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(
            value = "INSERT INTO InPatient (\n" +
                    "    patient_id,\n" +
                    "    admit_time,\n" +
                    "    emp_id,\n" +
                    "    first_name,\n" +
                    "    last_name,\n" +
                    "    gender,\n" +
                    "    dob,\n" +
                    "    address,\n" +
                    "    nation,\n" +
                    "    ethnic,\n" +
                    "    citizen_id,\n" +
                    "    occupation,\n" +
                    "    insurance_id,\n" +
                    "    emergency_cell,\n" +
                    "    height,\n" +
                    "    weight,\n" +
                    "    symptom,\n" +
                    "    request,\n" +
                    "    reason_dispatching,\n" +
                    "    department,\n" +
                    "    bed_cell,\n" +
                    "    room,\n" +
                    "    diagnose\n" +
                    ")\n" +
                    "SELECT\n" +
                    "    patient_id,\n" +
                    "    admit_time,\n" +
                    "    emp_id,\n" +
                    "    first_name,\n" +
                    "    last_name,\n" +
                    "    gender,\n" +
                    "    dob,\n" +
                    "    address,\n" +
                    "    nation,\n" +
                    "    ethnic,\n" +
                    "    citizen_id,\n" +
                    "    occupation,\n" +
                    "    insurance_id,\n" +
                    "    emergency_cell,\n" +
                    "    height,\n" +
                    "    weight,\n" +
                    "    symptom,\n" +
                    "    request,\n" +
                    "    NULL AS reason_dispatching, -- You may adjust this if needed\n" +
                    "    NULL AS department,         -- You may adjust this if needed\n" +
                    "    NULL AS bed_cell,           -- You may adjust this if needed\n" +
                    "    NULL AS room,               -- You may adjust this if needed\n" +
                    "    NULL AS diagnose            -- You may adjust this if needed\n" +
                    "FROM OutPatient " +
                    "WHERE patient_id = :patientId",
            nativeQuery = true
    )
    void copyOutpatientInfo(@Param("patientId") Long patientId);

//    @Query(
//            value = "SELECT * " +
//                    "FROM Inpatient " +
//                    "WHERE patient_id = :patientId",
//            nativeQuery = true
//    )
//    Inpatient findInpatient(@Param("patientId") Long patientId);
}
