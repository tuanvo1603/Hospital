package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.patient.InpatientRepository;

@Service
public class InpatientService {

    private final InpatientRepository inpatientRepository;

    @Autowired
    public InpatientService(InpatientRepository inpatientRepository) {
        this.inpatientRepository = inpatientRepository;
    }

    public Inpatient showInpatientInformation(String patientId) {
        return inpatientRepository.findById(patientId).get();
    }

}
