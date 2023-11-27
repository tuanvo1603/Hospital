package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.patient.Inpatient;

import java.sql.Date;

@Entity
@Table(name = "medicine_dispensation")
public class MedicineDispensation {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "date")
    private Date date;

    @Column(name = "half_a_day")
    @Enumerated(EnumType.STRING)
    private HalfADay halfADay;

    public enum HalfADay {
        Sáng,
        Chiều
    }

    @Column(name = "treatment_id")
    private String treatmentId;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Inpatient inpatient;

    public String getPatientId() {
        return patientId;
    }

    public Date getDate() {
        return date;
    }

    public HalfADay getHalfADay() {
        return halfADay;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHalfADay(HalfADay halfADay) {
        this.halfADay = halfADay;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

}
