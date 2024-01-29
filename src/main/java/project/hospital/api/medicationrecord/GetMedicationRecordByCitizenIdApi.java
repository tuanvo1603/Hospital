package project.hospital.api.medicationrecord;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.MedicationRecordNotFoundException;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.request.medicationrecord.GetMedicationRecordByCitizenIdRequest;
import project.hospital.response.medicationrecord.GetMedicationRecordByCitizenIdResponse;
import project.hospital.service.SessionService;
import project.hospital.service.medicationrecord.MedicationRecordService;

@Component
public class GetMedicationRecordByCitizenIdApi extends Api<GetMedicationRecordByCitizenIdRequest, GetMedicationRecordByCitizenIdResponse> {

    private final MedicationRecordService medicationRecordService;

    public GetMedicationRecordByCitizenIdApi(SessionService sessionService,
                                             MedicationRecordService medicationRecordService) {
        super(sessionService);
        this.medicationRecordService = medicationRecordService;
    }

    @Override
    public GetMedicationRecordByCitizenIdResponse execute(GetMedicationRecordByCitizenIdRequest requestData) {
        try{
            MedicationRecord medicationRecord = medicationRecordService.getMedicationRecordById(requestData.getCitizenId());
            return new GetMedicationRecordByCitizenIdResponse(medicationRecord);
        }catch (MedicationRecordNotFoundException e) {
            return new GetMedicationRecordByCitizenIdResponse(StatusCode.REQUEST.getCode(), "There is no medication record of this citizen in system.");
        }catch (Exception e) {
            return new GetMedicationRecordByCitizenIdResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
