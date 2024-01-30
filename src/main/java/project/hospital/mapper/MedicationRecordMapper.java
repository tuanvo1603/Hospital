package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.CommonPatientService;

@Component
public class MedicationRecordMapper {

    private final CommonPatientService commonPatientService;

    private final ModelMapper modelMapper;

    public MedicationRecordMapper(CommonPatientService commonPatientService, ModelMapper modelMapper) {
        this.commonPatientService = commonPatientService;
        this.modelMapper = modelMapper;
    }


    public MedicationRecord mapMedicationRecordFromPatient(String citizenId) {
        Patient patient = commonPatientService.getPatientByCitizenId(citizenId);
        return modelMapper.map(patient, MedicationRecord.class);
    }

    public MedicationRecordDetail mapMedicationRecordDetailFromPatient(String citizenId) {
        Patient patient = commonPatientService.getPatientByCitizenId(citizenId);
        return modelMapper.map(patient, MedicationRecordDetail.class);
    }
}
