package project.hospital.repository.ternary;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import project.hospital.model.ternary.RTI;

@Repository
public interface RTIRepository extends JpaRepository<RTI, Long> {
    @Transactional
    @Modifying
    @Query("INSERT INTO RTI(patientId, treatmentId) " +
            "VALUES(:patientId, :treatmentId)")
    void initRTI(@Param("patientId") Long patientId,
                 @Param("treatmentId") Long treatmentId);
}
