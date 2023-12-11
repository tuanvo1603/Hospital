package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.repository.patient.PatientDTORepository;
import project.hospital.repository.patient.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientDTORepository patientDTORepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientDTORepository patientDTORepository) {
        this.patientRepository = patientRepository;
        this.patientDTORepository = patientDTORepository;
    }

    public void deletePatient(Long patientId) {
        patientRepository.deletePatient(patientId);
    }

    public List<PatientDTO> findPatients() {
        return patientDTORepository.findPatients();
    }
}
