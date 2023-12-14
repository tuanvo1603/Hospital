package project.hospital.service.treatment;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;

@Service
public class HospitalFeeService {

    private final TreatmentService treatmentService;

    @Autowired
    public HospitalFeeService(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @Transactional
    public void initHospitalFee(Treatment treatment) {
        HospitalFee hospitalFee = new HospitalFee();
        treatment.setHospitalFee(hospitalFee);
//        hospitalFee.setTreatmentId(treatment.getTreatmentId());
        treatmentService.saveTreatment(treatment);
    }
}
