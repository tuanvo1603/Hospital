package project.hospital.service.medicationrecord;

import org.springframework.stereotype.Service;
import project.hospital.exception.MedicationRecordNotFoundException;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.repository.medicationrecord.MedicalRecordRepository;

@Service
public class MedicationRecordService {

    private final MedicalRecordRepository medicalRecordRepository;


    public MedicationRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicationRecord getMedicationRecordById(String citizenId) {
        return medicalRecordRepository.findById(citizenId).orElseThrow(MedicationRecordNotFoundException::new);
    }

    public MedicationRecord createMedicationRecord(MedicationRecord medicationRecord, String citizenId) {
        if(medicalRecordRepository.existsById(citizenId)) {
            MedicationRecord storedMedicationRecord = getMedicationRecordById(citizenId);
            medicationRecord.getMedicationRecordDetailList()
                    .forEach(medicationRecordDetail -> storedMedicationRecord.getMedicationRecordDetailList().add(medicationRecordDetail));
            return medicalRecordRepository.save(storedMedicationRecord);
        }else return medicalRecordRepository.save(medicationRecord);
    }
}
