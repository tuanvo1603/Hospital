package project.hospital.model.treatment.medication;

import jakarta.persistence.*;

@Entity
@Table(name = "medication_list")
public class MedicationList {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @ManyToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private PrescriptionDetail prescriptionDetail;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @Column(name = "quantity")
    private Integer quantity;

    public String getTreatmentId() {
        return treatmentId;
    }

    public PrescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public Medication getMedication() {
        return medication;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
