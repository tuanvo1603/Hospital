package project.hospital.api.treatment;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.request.treatment.GetHospitalFeeRequest;
import project.hospital.response.treatment.GetHospitalFeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.treatment.HospitalFeeService;

@Component
public class GetHospitalFeeApi extends Api<GetHospitalFeeRequest, GetHospitalFeeResponse> {

    private final HospitalFeeService hospitalFeeService;

    public GetHospitalFeeApi(SessionService sessionService,
                             HospitalFeeService hospitalFeeService) {
        super(sessionService);
        this.hospitalFeeService = hospitalFeeService;
    }

    @Override
    public GetHospitalFeeResponse execute(GetHospitalFeeRequest requestData) {
        try{
            HospitalFee hospitalFee = hospitalFeeService.getHospitalFeeById(requestData.getPatientId());

            return new GetHospitalFeeResponse(hospitalFee);
        }catch (PatientNotFoundException e) {
            return new GetHospitalFeeResponse(StatusCode.REQUEST.getCode(), "There is no managed hospital fee of the patient in system.");
        }catch (Exception e) {
            return new GetHospitalFeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
