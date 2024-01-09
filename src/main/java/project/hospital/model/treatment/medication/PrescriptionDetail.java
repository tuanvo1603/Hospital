package project.hospital.model.treatment.medication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "prescription_detail")
public class PrescriptionDetail {

    @Id
    @Column(name = "prescription_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionDetailId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "medication_id")
    @Nonnull
    private Long medicationId;

    @Column(name = "quantity_per_day")
    @Nonnull
    private Integer quantityPerDay;

    @Column(name = "start_time")
    @Nonnull
    private Date startTime;

    @Column(name = "end_time")
    @Nonnull
    private Date endTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medication_id", insertable = false, updatable = false)
    @JsonIgnore
    private Medication medication;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    @JsonBackReference
    private Treatment treatment;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPrescriptionDetailId() {
        return prescriptionDetailId;
    }

    public void setPrescriptionDetailId(Long prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Nonnull
    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(@Nonnull Long medicationId) {
        this.medicationId = medicationId;
    }

    @Nonnull
    public Integer getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(@Nonnull Integer quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }

    @Nonnull
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(@Nonnull Date startTime) {
        this.startTime = startTime;
    }

    @Nonnull
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(@Nonnull Date endTime) {
        this.endTime = endTime;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
