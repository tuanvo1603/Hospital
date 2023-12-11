package project.hospital.model.treatment;

import jakarta.persistence.*;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;

import java.sql.Date;

@Entity
@Table(name = "hospital_fee")
public class HospitalFee {

    @Id
    @Column(name = "treatment_id")
    private Long treatmentId;

    @Column(name = "total_money")
    private Integer totalMoney;

    @Column(name = "advance_payment")
    private Integer advancePayment;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "note")
    private String note;

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Integer getAdvancePayment() {
        return advancePayment;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public String getNote() {
        return note;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setAdvancePayment(Integer advancePayment) {
        this.advancePayment = advancePayment;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

}
