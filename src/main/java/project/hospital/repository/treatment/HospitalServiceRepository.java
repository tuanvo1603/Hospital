package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.service.HospitalServiceEntity;

@Repository
public interface HospitalServiceRepository extends JpaRepository<HospitalServiceEntity, Long> {
}
