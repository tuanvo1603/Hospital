package project.hospital.repository.patient;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.patient.Outpatient;

@Repository
public interface OutpatientRepository extends JpaRepository<Outpatient, Long> {
//    @Modifying
//    @Transactional
//    @Query(
//            value = "DELETE FROM Outpatient " +
//            "WHERE patient_id = :patientId",
//            nativeQuery = true)
//    void deleteOutpatientById(@Param("patientId") String patientId);
}
