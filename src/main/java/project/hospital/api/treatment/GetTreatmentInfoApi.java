package project.hospital.api.treatment;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.treatment.TreatmentService;

@Component
public class GetTreatmentInfoApi {

    private final TreatmentService treatmentService;

    public GetTreatmentInfoApi(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    public Treatment getTreatmentInfo(Long patientId) {
        return treatmentService.getTreatmentById(patientId);
    }
}
