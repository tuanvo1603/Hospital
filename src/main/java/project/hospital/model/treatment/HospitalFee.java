package project.hospital.model.treatment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.hospital.model.patient.Patient;

@Entity
@Table(name = "hospital_fee")
public class HospitalFee {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "total_money")
    private Integer totalMoney;

    @Column(name = "advance_payment")
    private Integer advancePayment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    @MapsId
    @JsonIgnore
    private Treatment treatment;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Integer getAdvancePayment() {
        return advancePayment;
    }


    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setAdvancePayment(Integer advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
