package project.hospital.repository.patient;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT new project.hospital.dto.PatientDTO(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.symptom, p.request, p.height, p.weight) " +
            "FROM Patient p"
    )
    List<PatientDTO> getPatientList();

    @Query("SELECT new project.hospital.dto.PatientDTO(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.symptom, p.request, p.height, p.weight) " +
            "FROM Patient p " +
            "WHERE p.department = :department " +
            "AND p.firstName = :patientFirstName"
    )
    List<PatientDTO> searchPatientByDepartment(
            @Param("patientFirstName") String patientFirstName,
            @Param("department") String department
    );

    @Query("SELECT new project.hospital.dto.PatientDTO(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.symptom, p.request, p.height, p.weight) " +
            "FROM Patient p " +
            "WHERE p.firstName = :patientFirstName " +
            "AND p.lastName = :patientLastName"
    ) List<PatientDTO> searchPatientByFullName(
            @Param("patientFirstName") String patientFirstName,
            @Param("patientLastName") String patientLastName
    );

    @Query("SELECT p " +
            "FROM Patient p " +
            "WHERE p.citizenId = :citizenId ")
    Patient getPatientByCitizenId(@Param("citizenId") String citizenId);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("INSERT INTO Inpatient i " +
            "(i.patientId, i.admitTime, i.employeeId, i.firstName, i.lastName, i.gender, i.dob, " +
            "i.address, i.nation, i.ethnic, i.citizenId, i.occupation, i.insuranceId, " +
            "i.emergencyCell, i.height, i.weight, i.symptom, i.request, " +
            "i.department, i.bedCell, i.room) " +
            "SELECT o.patientId, o.admitTime, o.employeeId, o.firstName, o.lastName, o.gender, " +
            "o.dob, o.address, o.nation, o.ethnic, o.citizenId, o.occupation, o.insuranceId, " +
            "o.emergencyCell, o.height, o.weight, o.symptom, o.request, NULL, NULL, NULL " +
            "FROM Outpatient o WHERE o.patientId = :patientId")
    void copyOutpatientInfo(@Param("patientId") Long patientId);
}
