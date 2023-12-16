package project.hospital.repository.ternary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.ternary.DTP;

@Repository
public interface TernaryRepository extends JpaRepository<DTP, Long> {
}
