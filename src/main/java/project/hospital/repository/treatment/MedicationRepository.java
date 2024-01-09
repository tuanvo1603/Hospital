package project.hospital.repository.treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.treatment.medication.Medication;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findAllByMedicationNameContainingIgnoreCase(String medicationName);
}
