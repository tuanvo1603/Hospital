package project.hospital.model.treatment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
}
