package project.hospital.repository.ternary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.ternary.Ternary;

@Repository
public interface TernaryRepository extends JpaRepository<Ternary, Long> {
}
