package project.hospital.service.employee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.patient.PatientService;

import java.util.List;

@Service
public class ShowingPatientService {
    private final PatientService outpatientService;

    @Autowired
    public ShowingPatientService(OutpatientService outpatientService) {
        this.outpatientService = outpatientService;
    }

    public List<PatientDTO> getPatientList() {
        return outpatientService.getPatientList();
    }

    public List<PatientDTO> getPatientByFullName(String firstName, String lastName) {
        return outpatientService.searchPatientByFullName(firstName, lastName);
    }

    public List<PatientDTO> getPatientByDepartment(String firstName, String department) {
        return outpatientService.searchPatientByDepartment(firstName, department);
    }
}
