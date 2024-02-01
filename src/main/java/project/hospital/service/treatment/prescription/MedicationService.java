package project.hospital.service.treatment.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.hospital.exception.MedicationQuantityNotEnoughException;
import project.hospital.exception.MedicationNotFoundException;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.repository.treatment.MedicationRepository;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication importMedicationList(Medication medication) {
        return medicationRepository.save(medication);
    }

    public List<Medication> getMedicationList(int page, int size) {
        return medicationRepository.findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }

    public Medication importMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public void deleteMedication(Long medicationId) {
        if(!medicationRepository.existsById(medicationId))
            throw new MedicationNotFoundException();
        medicationRepository.deleteById(medicationId);
    }

    public Medication getMedicationById(Long medicationId) {
        return medicationRepository.findById(medicationId).orElseThrow(MedicationNotFoundException::new);
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
