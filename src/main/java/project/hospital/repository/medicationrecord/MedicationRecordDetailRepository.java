package project.hospital.repository.medicationrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.medicationrecord.MedicationRecordDetail;

@Repository
public interface MedicationRecordDetailRepository extends JpaRepository<MedicationRecordDetail, String> {
}
