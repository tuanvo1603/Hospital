package project.hospital.response.patient;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.dto.PatientDTO;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetPatientsResponse extends ResponseData {

    private List<PatientDTO> patientDTOList;

    public GetPatientsResponse(List<PatientDTO> patientDTOList) {
        this.patientDTOList = patientDTOList;
    }

    public GetPatientsResponse(int code, String message) {
        super(code, message);
    }

    public List<PatientDTO> getPatientDTOList() {
        return patientDTOList;
    }

    public void setPatientDTOList(List<PatientDTO> patientDTOList) {
        this.patientDTOList = patientDTOList;
    }
}
