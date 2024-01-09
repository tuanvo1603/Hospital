package project.hospital.service.treatment.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.MedicationQuantityNotEnoughException;
import project.hospital.exception.MedicationNotFoundException;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.repository.treatment.MedicationRepository;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> importMedicationList(List<Medication> medicationList) {
        return medicationRepository.saveAll(medicationList);
    }

    public Medication importMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public void deleteMedication(Long medicationId) {
        medicationRepository.deleteById(medicationId);
    }

    public Medication getMedicationById(Long medicationId) {
        return medicationRepository.findById(medicationId).orElseThrow(MedicationNotFoundException::new);
    }

    public List<Medication> getMedicationByName(String medicationName) {
        return medicationRepository.findAllByMedicationNameContainingIgnoreCase(medicationName);
    }

    public void updateMedication(Long medicationId, Medication medication) {
        if(medicationRepository.existsById(medicationId))
            medicationRepository.save(medication);
        else
            throw new MedicationQuantityNotEnoughException();
    }

    public boolean isEnoughMedicationRemainingQuantity(Medication medication, int usedQuantity) {
        return medication.getRemaining() >= usedQuantity;
    }

    public void updateRemainingQuantity(Medication medication, int usedQuantity) {
        medication.setRemaining(medication.getRemaining() - usedQuantity);
        medicationRepository.save(medication);
    }
}
