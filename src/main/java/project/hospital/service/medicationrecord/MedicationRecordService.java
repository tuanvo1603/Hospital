package project.hospital.service.medicationrecord;

import org.springframework.stereotype.Service;
import project.hospital.exception.MedicationRecordNotFoundException;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.repository.medicationrecord.MedicalRecordRepository;
import project.hospital.service.patient.CommonPatientService;

@Service
public class MedicationRecordService {

    private final MedicalRecordRepository medicalRecordRepository;


    public MedicationRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicationRecord getMedicationRecordById(String citizenId) {
        return medicalRecordRepository.findById(citizenId).orElseThrow(MedicationRecordNotFoundException::new);
    }
}
