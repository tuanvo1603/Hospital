package project.hospital.repository.ternary;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.ternary.RTI;

@Repository
public interface RTIRepository extends JpaRepository<RTI, Long> {
}
