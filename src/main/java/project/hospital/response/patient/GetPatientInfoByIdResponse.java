package project.hospital.response.patient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.dto.PatientDTO;
import project.hospital.response.ResponseData;

@ResponseBody
public class GetPatientInfoByIdResponse extends ResponseData {

    private PatientDTO patientDTO;

    public GetPatientInfoByIdResponse(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public GetPatientInfoByIdResponse(int code, String message) {
        super(code, message);
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }
}
