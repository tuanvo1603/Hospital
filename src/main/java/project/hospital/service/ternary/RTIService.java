package project.hospital.service.ternary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.ternary.RTI;
import project.hospital.model.ternary.STO;
import project.hospital.repository.ternary.RTIRepository;

@Service
public class RTIService {

    private final RTIRepository rtiRepository;

    @Autowired
    public RTIService(RTIRepository rtiRepository) {
        this.rtiRepository = rtiRepository;
    }

    public void deleteRTIInDB(Long patientId) {
        rtiRepository.deleteRTIInDB(patientId);
    }

    public void initRTIFromSTO(STO sto) {
        RTI rti = new RTI();
        rti.setTreatmentId(sto.getTreatmentId());
        rti.setPatientId(sto.getPatientId());
        rtiRepository.saveAndFlush(rti);
    }
}
