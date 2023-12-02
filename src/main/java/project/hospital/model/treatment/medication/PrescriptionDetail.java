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
    private String treatmentId;

    @Column(name = "prescibed_date")
    private Date prescibedDate;

    @OneToMany(
            mappedBy = "prescriptionDetail",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<MedicationList> medicationLists = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    public String getTreatmentId() {
        return treatmentId;
    }

    public Date getPrescibedDate() {
        return prescibedDate;
    }

    public Set<MedicationList> getMedicationLists() {
        return medicationLists;
    }


    public void setPrescibedDate(Date prescibedDate) {
        this.prescibedDate = prescibedDate;
    }

    public void setMedicationLists(Set<MedicationList> medicationLists) {
        this.medicationLists = medicationLists;
    }

}
