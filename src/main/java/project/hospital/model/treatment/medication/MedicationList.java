package project.hospital.model.treatment.medication;

import jakarta.persistence.*;

@Entity
@Table(name = "medication_list")
public class MedicationList {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @OneToOne
    @MapsId
    @JoinColumn(
            name = "treatment_id",
            referencedColumnName = "treatment_id")
    private PrescriptionDetail prescriptionDetail;

    @ManyToOne
    @JoinColumn(
            name = "medication_id",
            referencedColumnName = "medication_id")
    private Medication medication;

    @Column(name = "quantity")
    private Integer quantity;
}
