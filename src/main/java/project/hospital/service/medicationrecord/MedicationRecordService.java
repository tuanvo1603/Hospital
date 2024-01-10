package project.hospital.service.medicationrecord;

import org.springframework.stereotype.Service;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.repository.medicationrecord.MedicalRecordRepository;

@Service
public class MedicationRecordService {

    private final MedicalRecordRepository medicalRecordRepository;


    public MedicationRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicationRecord getMedicationRecordById(String citizenId) {
        return medicalRecordRepository.findById(citizenId).orElseThrow()
    }
}
