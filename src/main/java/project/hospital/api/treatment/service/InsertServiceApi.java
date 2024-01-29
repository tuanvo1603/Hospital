package project.hospital.api.treatment.service;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.treatment.service.InsertServiceRequest;
import project.hospital.response.treatment.service.InsertServiceResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.service.HospitalService;

@Component
public class InsertServiceApi extends Api<InsertServiceRequest, InsertServiceResponse> {

    private final HospitalService hospitalService;

    public InsertServiceApi(SessionService sessionService, HospitalService hospitalService) {
        super(sessionService);
        this.hospitalService = hospitalService;
    }

    @Override
    public InsertServiceResponse execute(InsertServiceRequest requestData) {
        try{
            hospitalService.importHospitalFeeService(requestData.getHospitalServiceEntity());

            return new InsertServiceResponse();
        }catch (Exception e) {
            return new InsertServiceResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
