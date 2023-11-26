package project.hospital.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientList;
import project.hospital.repository.patient.PatientListRepository;

import java.util.List;

@Service
public class ShowingPatientService {
    private final PatientListRepository patientListRepository;

    @Autowired
    public ShowingPatientService(PatientListRepository patientListRepository) {
        this.patientListRepository = patientListRepository;
    }

    public List<PatientList> findPatients() {
        return patientListRepository.findPatients();
    }
}
