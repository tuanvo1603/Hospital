package project.hospital.mapper;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.treatment.TreatmentService;

@Component
public class TreatmentMapper {

    public Treatment cloneTreatment(Treatment treatment) {
        Treatment newTreatment = new Treatment();
        newTreatment.setHospitalFee(treatment.getHospitalFee());
        newTreatment.setTreatmentProcedure(treatment.getTreatmentProcedure());
        newTreatment.setDescription(treatment.getDescription());
        newTreatment.setDiagnostic(treatment.getDiagnostic());
        return newTreatment;
    }
}
