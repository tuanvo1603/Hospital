package project.hospital.response.treatment.prescription;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.dto.MedicationDTO;
import project.hospital.dto.PrescriptionDetailDTO;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetDistributedMedicationTodayResponse extends ResponseData {

    private List<PrescriptionDetailDTO> prescriptionDetailDTO;

    public GetDistributedMedicationTodayResponse(List<PrescriptionDetailDTO> prescriptionDetailDTO) {
        this.prescriptionDetailDTO = prescriptionDetailDTO;
    }

    public GetDistributedMedicationTodayResponse(int code, String message) {
        super(code, message);
    }

    public List<PrescriptionDetailDTO> getPrescriptionDetailDTO() {
        return prescriptionDetailDTO;
    }

    public void setPrescriptionDetailDTO(List<PrescriptionDetailDTO> prescriptionDetailDTO) {
        this.prescriptionDetailDTO = prescriptionDetailDTO;
    }
}
