package project.hospital.service.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.repository.patient.OutpatientRepository;

@Service
public class OutpatientService {

    private final OutpatientRepository outpatientRepository;
    private final InpatientService inpatientService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManager;

    @Autowired
    public OutpatientService(OutpatientRepository outpatientRepository, InpatientService inpatientService, EntityManager entityManager) {
        this.outpatientRepository = outpatientRepository;
        this.inpatientService = inpatientService;
        this.entityManager = entityManager;
    }

    public Outpatient initOutpatient(Outpatient outpatient) {
        return outpatientRepository.save(outpatient);
    }

    public void deleteOutpatient(Outpatient outpatient) {
        outpatientRepository.delete(outpatient);
    }

    public Outpatient findOutpatient(Long patientId) throws PatientCanNotBeFoundException {
        return outpatientRepository
                .findById(patientId)
                .orElseThrow(PatientCanNotBeFoundException::new);
    }

    public Outpatient copyPatientInfo(Inpatient oldInpatient) throws PatientCanNotBeFoundException {
        Outpatient outpatient = entityManager.merge(this
                                        .findOutpatient(oldInpatient.getPatientId()));
        inpatientService.copyOutpatientInfo(outpatient.getPatientId());
        return outpatient;
    }
}
