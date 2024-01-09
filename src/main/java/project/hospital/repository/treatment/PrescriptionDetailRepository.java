package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@Repository
public interface PrescriptionDetailRepository extends JpaRepository<PrescriptionDetail, Long> {

    List<PrescriptionDetail> findAllByPatientId(Long patientId);
}
