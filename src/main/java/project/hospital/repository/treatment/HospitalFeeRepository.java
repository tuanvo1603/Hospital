package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.HospitalFee;
@Repository
public interface HospitalFeeRepository extends JpaRepository<HospitalFee, Long> {
}
