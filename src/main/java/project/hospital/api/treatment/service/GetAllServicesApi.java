package project.hospital.api.treatment.service;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.request.treatment.service.GetAllServicesRequest;
import project.hospital.response.treatment.service.GetAllServicesResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.service.HospitalService;

import java.util.List;

@Component
public class GetAllServicesApi extends Api<GetAllServicesRequest, GetAllServicesResponse> {

    private final HospitalService hospitalService;

    public GetAllServicesApi(HospitalService hospitalService, SessionService sessionService) {
        super(sessionService);
        this.hospitalService = hospitalService;
    }

    public List<HospitalServiceEntity> getServiceList() {
        return hospitalService.getHospitalServiceList();
    }

    @Override
    public GetAllServicesResponse execute(GetAllServicesRequest requestData) {
        try{
            List<HospitalServiceEntity> hospitalServiceEntityList = hospitalService.getHospitalServiceList();

            return new GetAllServicesResponse(hospitalServiceEntityList);
        }catch (Exception e) {
            return new GetAllServicesResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
