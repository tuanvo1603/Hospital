package project.hospital.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project.hospital.dto.MedicationDTO;
import project.hospital.dto.PrescriptionDetailDTO;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@Component
public class PrescriptionDetailMapper {

    private final ModelMapper modelMapper;

    public PrescriptionDetailMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private PrescriptionDetailDTO mapToPrescriptionDetailDTO(PrescriptionDetail prescriptionDetail) {
        PrescriptionDetailDTO prescriptionDetailDTO = new PrescriptionDetailDTO();
        prescriptionDetailDTO.setMedicationDTO(modelMapper.map(prescriptionDetail.getMedication(), MedicationDTO.class));
        prescriptionDetailDTO.setQuantityPerDay(prescriptionDetail.getQuantityPerDay());
        return prescriptionDetailDTO;
    }

    public List<PrescriptionDetailDTO> mapToPrescriptionDetailDTOList(List<PrescriptionDetail> prescriptionDetailList) {
        return prescriptionDetailList.stream().map(this::mapToPrescriptionDetailDTO).toList();
    }
}
