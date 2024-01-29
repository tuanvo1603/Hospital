package project.hospital.response.treatment;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.treatment.Treatment;
import project.hospital.response.ResponseData;

@ResponseBody
public class GetTreatmentResponse extends ResponseData {

    private Treatment treatment;

    public GetTreatmentResponse(int code, String message) {
        super(code, message);
    }

    public GetTreatmentResponse(Treatment treatment) {
        this.treatment = treatment;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
