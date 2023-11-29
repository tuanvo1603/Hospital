package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface InpatientRepository extends JpaRepository<Inpatient, String> {

    @Query(value = "SELECT * " +
                    "FROM admitted_patient p " +
                    "JOIN inpatient ON p.patient_id = inpatient.patient_id " +
                    "WHERE p.first_name = :patientFirstName " +
                    "AND inpatient.department = :department",
            nativeQuery = true
    )
    List<Inpatient> searchPatientByDepartment(
            @Param("patientFirstName") String patientFirstName,
            @Param("department") String department
    );
}
