package project.hospital.api.treatment.service;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.ServiceNotFoundException;
import project.hospital.request.treatment.service.UpdateServiceRequest;
import project.hospital.response.treatment.service.UpdateServiceResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.service.HospitalService;

@Component
public class UpdateServiceApi extends Api<UpdateServiceRequest, UpdateServiceResponse> {

    private final HospitalService hospitalService;

    public UpdateServiceApi(SessionService sessionService, HospitalService hospitalService) {
        super(sessionService);
        this.hospitalService = hospitalService;
    }

    @Override
    public UpdateServiceResponse execute(UpdateServiceRequest requestData) {
        try{
            hospitalService.updateHospitalService(requestData.getServiceId(), requestData.getHospitalServiceEntity());

            return new UpdateServiceResponse();
        }catch (ServiceNotFoundException e) {
            return new UpdateServiceResponse(StatusCode.REQUEST.getCode(), "Error in serviceId.");
        }catch (Exception e) {
            return new UpdateServiceResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
