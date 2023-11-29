package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientDTORepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowingPatientService {
    private static final int INDEX_OF_FIRST_PARA = 0;
    private static final int INDEX_OF_SECOND_PARA = 1;
    private final PatientDTORepository patientDTORepository;
    private final InpatientRepository inpatientRepository;

    public ShowingPatientService(PatientDTORepository patientDTORepository, InpatientRepository inpatientRepository) {
        this.patientDTORepository = patientDTORepository;
        this.inpatientRepository = inpatientRepository;
    }

    @Autowired
    public List<PatientDTO> findPatients() {
        return patientDTORepository.findPatients();
    }

    public List<PatientDTO> searchPatientByFullName(ArrayList<String> patientInfo) {
        return patientDTORepository.searchPatientByFullName(patientInfo.get(INDEX_OF_FIRST_PARA), patientInfo.get(INDEX_OF_SECOND_PARA));
    }

    public List<Inpatient> searchPatientByDepartment(ArrayList<String> patientInfo) {
        return inpatientRepository.searchPatientByDepartment(patientInfo.get(INDEX_OF_FIRST_PARA), patientInfo.get(INDEX_OF_SECOND_PARA));
    }
}
