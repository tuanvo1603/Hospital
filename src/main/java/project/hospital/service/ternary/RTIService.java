package project.hospital.service.ternary;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.ternary.RTI;
import project.hospital.model.ternary.STO;
import project.hospital.repository.ternary.RTIRepository;
import project.hospital.repository.ternary.TernaryRepository;

@Service
public class RTIService extends TernaryService{

    private final RTIRepository rtiRepository;

    @Autowired
    public RTIService(RTIRepository rtiRepository, TernaryRepository ternaryRepository) {
        super(ternaryRepository);
        this.rtiRepository = rtiRepository;
    }

    @Transactional
    public void deleteRTIById(Long patientId) {
        rtiRepository.deleteById(patientId);
    }

    @Transactional
    public void initRTIFromSTO(STO sto) {
        RTI rti = new RTI();
        rti.setTreatmentId(sto.getTreatmentId());
        rti.setPatientId(sto.getPatientId());
        rtiRepository.saveAndFlush(rti);
    }
}
