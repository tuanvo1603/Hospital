package project.hospital.response.treatment;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.response.ResponseData;

@ResponseBody
public class GetHospitalFeeResponse extends ResponseData {

    private HospitalFee hospitalFee;

    public GetHospitalFeeResponse(int code, String message) {
        super(code, message);
    }

    public GetHospitalFeeResponse(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    public HospitalFee getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }
}
