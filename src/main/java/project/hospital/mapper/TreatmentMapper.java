package project.hospital.mapper;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.treatment.TreatmentService;

@Component
public class TreatmentMapper {

    private final TreatmentService treatmentService;

    public TreatmentMapper(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    public Treatment mapTreatmentOutpatientToInpatient(Long outpatientId) {
        Treatment mappedTreatment = treatmentService.getTreatmentById(outpatientId);
        Treatment treatment = new Treatment();
        treatment.setHospitalFee(mappedTreatment.getHospitalFee());
        treatment.setTreatmentProcedure(mappedTreatment.getTreatmentProcedure());
        treatment.setDescription(mappedTreatment.getDescription());
        treatment.setDiagnostic(mappedTreatment.getDiagnostic());
        return treatment;
    }
}
