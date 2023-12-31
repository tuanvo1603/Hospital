package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.TreatmentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMapper {

    private final ModelMapper modelMapper;

    private final OutpatientService outpatientService;

    @Autowired
    public PatientMapper(ModelMapper modelMapper, OutpatientService outpatientService) {
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

    public Inpatient  mapOutpatientToInpatient(Long outpatientId) {
        Outpatient outpatient = outpatientService.getPatientById(outpatientId);
        Inpatient inpatient = modelMapper.map(outpatient, Inpatient.class);
        inpatient.setPatientId(null);
        return inpatient;
    }

}
