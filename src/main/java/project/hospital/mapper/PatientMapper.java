package project.hospital.mapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.CommonPatientService;
import project.hospital.service.patient.OutpatientService;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    private final ModelMapper modelMapper;

    private final OutpatientService outpatientService;



    @Autowired
    public PatientMapper(ModelMapper modelMapper,
                         OutpatientService outpatientService) {
        this.modelMapper = modelMapper;
        this.outpatientService = outpatientService;
    }

    public PatientDTO mapToPatientDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }

    public List<PatientDTO> mapToPatientDTOList(List<Patient> patientList) {
        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientList.forEach(patient -> patientDTOList.add(this.mapToPatientDTO(patient)));
        return patientDTOList;
    }

    public Inpatient  mapOutpatientToInpatient(Outpatient outpatient) {
        Inpatient inpatient = modelMapper.map(outpatient, Inpatient.class);
        inpatient.setPatientId(null);
        return inpatient;
    }

}
