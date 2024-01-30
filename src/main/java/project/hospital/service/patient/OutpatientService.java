package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.CitizenIdIsExistedException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.patient.Outpatient;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.repository.patient.PatientRepository;

@Service
public class OutpatientService extends CommonPatientService implements IPatientService<Outpatient> {

    private final OutpatientRepository outpatientRepository;

    public OutpatientService(PatientRepository patientRepository,
                             OutpatientRepository outpatientRepository) {
        super(patientRepository);
        this.outpatientRepository = outpatientRepository;
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
        if(patientRepository.existsByCitizenId(outpatient.getCitizenId()))
            throw new CitizenIdIsExistedException();
        return outpatientRepository.save(outpatient);
    }

}
