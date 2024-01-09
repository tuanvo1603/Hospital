package project.hospital.dto;

public class PrescriptionDetailDTO {

    private MedicationDTO medicationDTO;

    private Integer quantityPerDay;

    public MedicationDTO getMedicationDTO() {
        return medicationDTO;
    }

    public void setMedicationDTO(MedicationDTO medicationDTO) {
        this.medicationDTO = medicationDTO;
    }

    public Integer getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(Integer quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }
}
