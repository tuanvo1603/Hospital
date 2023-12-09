package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.InpatientRepository;

@Service
public class PatientService {

    private final InpatientRepository inpatientRepository;
    @Autowired
    public PatientService(InpatientRepository inpatientRepository) {
        this.inpatientRepository = inpatientRepository;
    }

    public Patient showInpatientInformation(Long patientId) {
        return inpatientRepository.findById(patientId).get();
    }

}
