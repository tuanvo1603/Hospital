package project.hospital.api.treatment;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.treatment.Treatment;
import project.hospital.request.treatment.GetTreatmentRequest;
import project.hospital.response.treatment.GetTreatmentResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class GetTreatmentApi extends Api<GetTreatmentRequest, GetTreatmentResponse> {

    private final TreatmentService treatmentService;

    public GetTreatmentApi(TreatmentService treatmentService, SessionService sessionService) {
        super(sessionService);
        this.treatmentService = treatmentService;
    }

    @Override
    public GetTreatmentResponse execute(GetTreatmentRequest requestData) {
        try {
            Treatment treatment = treatmentService.getTreatmentById(requestData.getPatientId());

            return new GetTreatmentResponse(treatment);
        }catch (PatientNotFoundException e) {
            return new GetTreatmentResponse(StatusCode.REQUEST.getCode(), "Patient may be not managed in system.");
        }catch (Exception e) {
            return new GetTreatmentResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
