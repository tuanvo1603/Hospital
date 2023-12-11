package project.hospital.service.employee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.PatientService;

import java.util.List;

@Service
public class ShowingPatientService {
    private final InpatientService inpatientService;

    private final PatientService patientService;

    @Autowired
    public ShowingPatientService(InpatientService inpatientService, PatientService patientService) {
        this.inpatientService = inpatientService;
        this.patientService = patientService;
    }

    public List<PatientDTO> findPatients() {
        return patientService.findPatients();
    }

    public List<Patient> searchPatientByFullName(List<String> patientInfo) {
        return inpatientService.searchPatientByFullName(patientInfo);
    }

    public List<Patient> searchPatientByDepartment(List<String> patientInfo) {
        return inpatientService.searchPatientByDepartment(patientInfo);
    }
}
