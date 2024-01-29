package project.hospital.response.treatment.medication;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetAllMedicationsResponse extends ResponseData {

    private List<Medication> medicationList;

    public GetAllMedicationsResponse(int code, String message) {
        super(code, message);
    }

    public GetAllMedicationsResponse(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }
}
