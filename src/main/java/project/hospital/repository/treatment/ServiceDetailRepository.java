package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.service.ServiceDetail;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Long> {
}
