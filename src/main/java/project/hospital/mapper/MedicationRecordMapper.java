package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.CommonPatientService;

@Component
public class MedicationRecordMapper {

    private final ModelMapper modelMapper;

    public MedicationRecordMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MedicationRecord mapMedicationRecordFromPatient(Patient patient) {
        return modelMapper.map(patient, MedicationRecord.class);
    }

    public MedicationRecordDetail mapMedicationRecordDetailFromPatient(Patient patient) {
        return modelMapper.map(patient, MedicationRecordDetail.class);
    }
}
