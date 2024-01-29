package project.hospital.api.treatment.medication;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.treatment.medication.DeleteMedicationRequest;
import project.hospital.response.employee.DeleteEmployeeResponse;
import project.hospital.response.treatment.medication.DeleteMedicationResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.prescription.MedicationService;

@Component
public class DeleteMedicationApi extends Api<DeleteMedicationRequest, DeleteMedicationResponse> {

    private final MedicationService medicationService;

    public DeleteMedicationApi(SessionService sessionService, MedicationService medicationService) {
        super(sessionService);
        this.medicationService = medicationService;
    }

    @Override
    public DeleteMedicationResponse execute(DeleteMedicationRequest requestData) {
        try {
            medicationService.deleteMedication(requestData.getMedicationId());

            return new DeleteMedicationResponse();
        }catch (Exception e) {
            return new DeleteMedicationResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
