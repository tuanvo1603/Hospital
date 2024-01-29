package project.hospital.api.treatment.service;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.ServiceNotFoundException;
import project.hospital.request.treatment.service.DeleteServiceRequest;
import project.hospital.response.treatment.service.DeleteServiceResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.service.HospitalService;

@Component
public class DeleteServiceApi extends Api<DeleteServiceRequest, DeleteServiceResponse> {

    private final HospitalService hospitalService;

    public DeleteServiceApi(SessionService sessionService, HospitalService hospitalService) {
        super(sessionService);
        this.hospitalService = hospitalService;
    }

    @Override
    public DeleteServiceResponse execute(DeleteServiceRequest requestData) {
        try{
            hospitalService.deleteHospitalService(requestData.getServiceId());

            return new DeleteServiceResponse();
        } catch (ServiceNotFoundException e) {
            return new DeleteServiceResponse(StatusCode.REQUEST.getCode(), "Error in serviceId.");
        } catch (Exception e) {
            return new DeleteServiceResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
