package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.patient.Outpatient;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.repository.patient.PatientRepository;
import project.hospital.repository.treatment.TreatmentRepository;
import project.hospital.service.treatment.TreatmentService;

@Service
public class OutpatientService extends CommonPatientService implements IPatientService<Outpatient> {

    private final OutpatientRepository outpatientRepository;

    private final TreatmentRepository treatmentRepository;

    @Autowired
    public OutpatientService(PatientRepository patientRepository,
                             OutpatientRepository outpatientRepository,
                             TreatmentRepository treatmentRepository) {
        super(patientRepository);
        this.outpatientRepository = outpatientRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Outpatient getPatientById(Long patientId) {
        return outpatientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    public void checkExistenceOfPatient(Long patientId) {
        if(!outpatientRepository.existsById(patientId))
            throw new PatientNotFoundException();
    }

    @Override
    public Outpatient admitPatient(Outpatient outpatient) {
        return outpatientRepository.save(outpatient);
    }

}
