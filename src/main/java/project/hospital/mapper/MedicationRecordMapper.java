package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.CommonPatientService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class MedicationRecordMapper {

    private final CommonPatientService commonPatientService;

    private final ModelMapper modelMapper;

    private final TreatmentService treatmentService;

    public MedicationRecordMapper(CommonPatientService commonPatientService, ModelMapper modelMapper, TreatmentService treatmentService) {
        this.commonPatientService = commonPatientService;
        this.modelMapper = modelMapper;
        this.treatmentService = treatmentService;
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
