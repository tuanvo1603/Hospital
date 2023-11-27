package project.hospital.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.schedule.MedicineDispensation;

@Repository
public interface MedicineDispensationRepository extends JpaRepository<MedicineDispensation, String> {
}
