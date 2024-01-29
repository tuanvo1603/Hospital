package project.hospital.api.medicationrecord;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.medicationrecord.InsertMedicationRecordRequest;
import project.hospital.response.medicationrecord.InsertMedicationRecordResponse;
import project.hospital.service.SessionService;
import project.hospital.service.medicationrecord.MedicationRecordDetailService;

@Component
public class InsertMedicationRecordApi extends Api<InsertMedicationRecordRequest, InsertMedicationRecordResponse> {

    private final MedicationRecordDetailService medicationRecordDetailService;

    public InsertMedicationRecordApi(SessionService sessionService, MedicationRecordDetailService medicationRecordDetailService) {
        super(sessionService);
        this.medicationRecordDetailService = medicationRecordDetailService;
    }

    @Override
    public InsertMedicationRecordResponse execute(InsertMedicationRecordRequest requestData) {
        try{
            medicationRecordDetailService.createMedicationRecordDetail(requestData.getDescription(), requestData.getCitizenId());

            return new InsertMedicationRecordResponse();
        }catch (Exception e) {
            return new InsertMedicationRecordResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
