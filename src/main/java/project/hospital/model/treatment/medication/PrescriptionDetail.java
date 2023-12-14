package project.hospital.model.treatment.medication;

import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prescription_detail")
public class PrescriptionDetail {

    @Id
    @Column(name = "treatment_id")
    private Long treatmentId;

    @Column(name = "prescibed_date")
    private Date prescribedDate;

    @OneToMany(
            mappedBy = "prescriptionDetail",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<MedicationList> medicationLists = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private Treatment treatment;

    public Long getTreatmentId() {
        return treatmentId;
    }

    public Date getPrescribedDate() {
        return prescribedDate;
    }

    public Set<MedicationList> getMedicationLists() {
        return medicationLists;
    }


    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate = prescribedDate;
    }

    public void setMedicationLists(Set<MedicationList> medicationLists) {
        this.medicationLists = medicationLists;
    }

}
