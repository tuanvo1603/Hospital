package project.hospital.service.treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.treatment.TreatmentRepository;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    @Autowired
    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public void initHospitalFee(Treatment treatment) {
        HospitalFee hospitalFee = new HospitalFee();
        treatment.setHospitalFee(hospitalFee);
        hospitalFee.setTreatmentId(treatment.getTreatmentId());
        treatmentRepository.save(treatment);
    }

    public Treatment initTreatment() {
        return treatmentRepository.save(new Treatment());
    }
}
