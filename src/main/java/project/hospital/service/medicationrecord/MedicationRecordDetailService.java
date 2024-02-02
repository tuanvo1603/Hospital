package project.hospital.service.medicationrecord;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.mapper.MedicationRecordMapper;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Patient;
import project.hospital.repository.medicationrecord.MedicalRecordRepository;
import project.hospital.repository.medicationrecord.MedicationRecordDetailRepository;
import project.hospital.repository.patient.PatientRepository;

import java.util.Optional;

@Service
public class MedicationRecordDetailService {

    private final MedicalRecordRepository medicalRecordRepository;

    private final MedicationRecordDetailRepository medicationRecordDetailRepository;

    private final PatientRepository patientRepository;

    private final MedicationRecordMapper medicationRecordMapper;

    public MedicationRecordDetailService(MedicalRecordRepository medicalRecordRepository,
                                         MedicationRecordDetailRepository medicationRecordDetailRepository,
                                         PatientRepository patientRepository,
                                         MedicationRecordMapper medicationRecordMapper) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.medicationRecordDetailRepository = medicationRecordDetailRepository;
        this.patientRepository = patientRepository;
        this.medicationRecordMapper = medicationRecordMapper;
    }

    @Transactional
    public MedicationRecordDetail createMedicationRecordDetail(String description, String citizenId) {
        Optional<MedicationRecord> storedMedicationRecordOptional = medicalRecordRepository.findById(citizenId);
        Patient patient = patientRepository.findPatientByCitizenId(citizenId);
        if(storedMedicationRecordOptional.isPresent()) {
            MedicationRecordDetail medicationRecordDetail = medicationRecordMapper.mapMedicationRecordDetailFromPatient(patient);
            medicationRecordDetail.setDescription(description);
            medicationRecordDetail.setMedicationRecord(storedMedicationRecordOptional.get());
            return medicationRecordDetailRepository.save(medicationRecordDetail);
        }else {
            MedicationRecord medicationRecord = medicationRecordMapper.mapMedicationRecordFromPatient(patient);
            MedicationRecordDetail medicationRecordDetail = medicationRecordMapper.mapMedicationRecordDetailFromPatient(patient);
            medicationRecordDetail.setDescription(description);
            MedicationRecord storedMedicationRecord = medicalRecordRepository.save(medicationRecord);
            medicationRecordDetail.setMedicationRecord(storedMedicationRecord);
            return medicationRecordDetailRepository.save(medicationRecordDetail);
        }
    }
}
