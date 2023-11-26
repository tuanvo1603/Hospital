package project.hospital.model.treatment.medication;

import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "prescription_detail")
public class PrescriptionDetail {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "prescribed_date")
    private Date prescibedDate;

    @OneToOne(
            mappedBy = "prescriptionDetail",
            cascade = CascadeType.ALL)
    private MedicationList medicationList;

    @OneToOne
    @MapsId
    @JoinColumn(
            name = "treatment_id",
            referencedColumnName = "treatment_id")
    private Treatment treatment;
}
