package project.hospital.api.treatment.medication;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.MedicationNotFoundException;
import project.hospital.request.treatment.medication.UpdateMedicationRequest;
import project.hospital.response.treatment.medication.UpdateMedicationResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.prescription.MedicationService;

@Component
public class UpdateMedicationApi extends Api<UpdateMedicationRequest, UpdateMedicationResponse> {

    private final MedicationService medicationService;

    public UpdateMedicationApi(SessionService sessionService, MedicationService medicationService) {
        super(sessionService);
        this.medicationService = medicationService;
    }

    @Override
    public UpdateMedicationResponse execute(UpdateMedicationRequest requestData) {
        try{
            medicationService.updateMedication(requestData.getMedicationId(), requestData.getMedication());

            return new UpdateMedicationResponse();
        }catch (MedicationNotFoundException e) {
            return new UpdateMedicationResponse(StatusCode.REQUEST.getCode(), "Error in medicationId.");
        }catch (Exception e) {
            return new UpdateMedicationResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
