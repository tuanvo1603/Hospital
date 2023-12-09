package project.hospital.repository.ternary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.ternary.RTI;

@Repository
public interface RTIRepository extends JpaRepository<RTI, Long> {
}
