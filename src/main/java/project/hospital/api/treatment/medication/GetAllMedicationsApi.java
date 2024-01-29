package project.hospital.api.treatment.medication;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.request.treatment.medication.GetAllMedicationsRequest;
import project.hospital.response.treatment.medication.GetAllMedicationsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.prescription.MedicationService;

import java.util.List;

@Component
public class GetAllMedicationsApi extends Api<GetAllMedicationsRequest, GetAllMedicationsResponse> {

    private final MedicationService medicationService;

    public GetAllMedicationsApi(MedicationService medicationService, SessionService sessionService) {
        super(sessionService);
        this.medicationService = medicationService;
    }

    public List<Medication> getMedicationList() {
        return medicationService.getMedicationList();
    }

    @Override
    public GetAllMedicationsResponse execute(GetAllMedicationsRequest requestData) {
        try{
            List<Medication> medicationList = medicationService.getMedicationList();

            return new GetAllMedicationsResponse(medicationList);
        }catch (Exception e) {
            return new GetAllMedicationsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
