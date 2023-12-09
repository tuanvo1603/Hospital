package project.hospital.service.employee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientDTORepository;

import java.util.List;

@Service
public class ShowingPatientService {
    private final int FIRSTNAME = 0;
    private final PatientDTORepository patientDTORepository;
    private final InpatientRepository inpatientRepository;
    @Autowired
    public ShowingPatientService(PatientDTORepository patientDTORepository, InpatientRepository inpatientRepository) {
        this.patientDTORepository = patientDTORepository;
        this.inpatientRepository = inpatientRepository;
    }

    @Autowired
    public List<PatientDTO> findPatients() {
        return patientDTORepository.findPatients();
    }

    public List<Patient> searchPatientByFullName(List<String> patientInfo) {
        int LASTNAME = 1;
        return inpatientRepository.searchPatientByFullName(patientInfo.get(FIRSTNAME), patientInfo.get(LASTNAME));
    }

    public List<Patient> searchPatientByDepartment(List<String> patientInfo) {
        int DEPARTMENT = 1;
        return inpatientRepository.searchPatientByDepartment(patientInfo.get(FIRSTNAME), patientInfo.get(DEPARTMENT));
    }
}
