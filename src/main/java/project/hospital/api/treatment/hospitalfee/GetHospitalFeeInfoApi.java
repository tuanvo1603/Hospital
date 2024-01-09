package project.hospital.api.treatment.hospitalfee;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.service.treatment.HospitalFeeService;

@Component
public class GetHospitalFeeInfoApi {

    private final HospitalFeeService hospitalFeeService;

    public GetHospitalFeeInfoApi(HospitalFeeService hospitalFeeService) {
        this.hospitalFeeService = hospitalFeeService;
    }

    public HospitalFee getHospitalFeeInfo(Long patientId) {
        return hospitalFeeService.getHospitalFeeById(patientId);
    }
}
