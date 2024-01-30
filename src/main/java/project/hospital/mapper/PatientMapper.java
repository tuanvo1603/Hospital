package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {

    private final ModelMapper modelMapper;

    public PatientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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
