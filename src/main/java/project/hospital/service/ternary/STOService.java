package project.hospital.service.ternary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.ternary.STO;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.ternary.STORepository;
@Service
public class STOService {

    private final STORepository stoRepository;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private final EntityManager entityManager;

    @Autowired
    public STOService(STORepository stoRepository, EntityManager entityManager) {
        this.stoRepository = stoRepository;
        this.entityManager = entityManager;
    }

    public void deleteSTOInDB(Long patientId) {
        stoRepository.deleteSTOInDB(patientId);
    }

    public void initSTO(Outpatient outpatient, Treatment treatment) {
        STO sto = new STO();
        sto.setTreatmentId(treatment.getTreatmentId());
        sto.setPatientId(outpatient.getPatientId());
        stoRepository.save(sto);
    }

    public STO getPatientSTO(Outpatient outpatient) throws PatientCanNotBeFoundException {
        return entityManager
                .merge(stoRepository
                        .findById(outpatient.getPatientId())
                        .orElseThrow(PatientCanNotBeFoundException::new));
    }
}
