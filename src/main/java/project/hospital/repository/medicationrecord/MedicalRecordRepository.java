package project.hospital.repository.medicationrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.medicationrecord.MedicationRecord;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicationRecord, String> {
}
