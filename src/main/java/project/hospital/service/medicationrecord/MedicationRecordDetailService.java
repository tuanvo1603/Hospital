package project.hospital.service.medicationrecord;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.mapper.MedicationRecordMapper;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.repository.medicationrecord.MedicalRecordRepository;
import project.hospital.repository.medicationrecord.MedicationRecordDetailRepository;

@Service
public class MedicationRecordDetailService {

    private final MedicalRecordRepository medicalRecordRepository;

    private final MedicationRecordDetailRepository medicationRecordDetailRepository;

    private final MedicationRecordMapper medicationRecordMapper;

    public MedicationRecordDetailService(MedicalRecordRepository medicalRecordRepository,
                                         MedicationRecordDetailRepository medicationRecordDetailRepository,
                                         MedicationRecordMapper medicationRecordMapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.medicationRecordDetailRepository = medicationRecordDetailRepository;
        this.medicationRecordMapper = medicationRecordMapper;
    }

    @Transactional
    public MedicationRecordDetail createMedicationRecordDetail(String description, String citizenId) {
        if(medicalRecordRepository.existsById(citizenId)) {
            MedicationRecord storedMedicationRecord = medicalRecordRepository.findById(citizenId).get();
            MedicationRecordDetail medicationRecordDetail = medicationRecordMapper.mapMedicationRecordDetailFromPatient(citizenId);
            medicationRecordDetail.setDescription(description);
            medicationRecordDetail.setMedicationRecord(storedMedicationRecord);
            return medicationRecordDetailRepository.save(medicationRecordDetail);
        }else {
            MedicationRecord medicationRecord = medicationRecordMapper.mapMedicationRecordFromPatient(citizenId);
            MedicationRecordDetail medicationRecordDetail = medicationRecordMapper.mapMedicationRecordDetailFromPatient(citizenId);
            medicationRecordDetail.setDescription(description);
            MedicationRecord storedMedicationRecord = medicalRecordRepository.save(medicationRecord);
            medicationRecordDetail.setMedicationRecord(storedMedicationRecord);
            return medicationRecordDetailRepository.save(medicationRecordDetail);
        }
    }
}
