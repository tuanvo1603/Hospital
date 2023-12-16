package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.employee.Nurse;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;

import java.sql.Date;

@Entity
@Table(name = "medicine_dispensation")
public class MedicineDispensation {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "date")
    private Date date;

    @Column(name = "nurse_in_charge_id")
    private Long nurseId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "half_a_day")
    @Enumerated(EnumType.STRING)
    private HalfADay halfADay;

    public enum HalfADay {
        Sáng,
        Chiều
    }

    @Column(name = "treatment_id")
    private Long treatmentId;

    @OneToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private PrescriptionDetail prescriptionDetail;

    @OneToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private ServiceDetail serviceDetail;

    public Date getDate() {
        return date;
    }

    public HalfADay getHalfADay() {
        return halfADay;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public PrescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHalfADay(HalfADay halfADay) {
        this.halfADay = halfADay;
    }

    public void setPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }

    public void setServiceDetail(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
