package project.hospital.model.treatment;

import jakarta.persistence.*;

@Entity
@Table(name = "medication_list")
public class MedicationList {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "medication_id")
    @JoinColumn(name = "")
    private String medicationId;
}
