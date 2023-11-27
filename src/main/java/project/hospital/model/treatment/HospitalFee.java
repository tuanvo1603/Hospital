package project.hospital.model.treatment;

import jakarta.persistence.*;
import project.hospital.model.patient.Patient;

import java.sql.Date;

@Entity
@Table(name = "hospital_fee")
public class HospitalFee {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "total_money")
    private Integer totalMoney;

    @Column(name = "advance_payment")
    private Integer advancePayment;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "note")
    private String note;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

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
}
