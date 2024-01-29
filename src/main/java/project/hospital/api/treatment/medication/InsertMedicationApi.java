package project.hospital.api.treatment.medication;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.treatment.medication.InsertMedicationRequest;
import project.hospital.response.treatment.medication.InsertMedicationResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.prescription.MedicationService;

@Component
public class InsertMedicationApi extends Api<InsertMedicationRequest, InsertMedicationResponse> {

    private final MedicationService medicationService;

    public InsertMedicationApi(SessionService sessionService, MedicationService medicationService) {
        super(sessionService);
        this.medicationService = medicationService;
    }

    @Override
    public InsertMedicationResponse execute(InsertMedicationRequest requestData) {
        try{
            medicationService.importMedication(requestData.getMedication());

            return new InsertMedicationResponse();
        }catch (Exception e) {
            return  new InsertMedicationResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
