package project.hospital.model.treatment;

import jakarta.persistence.*;
import project.hospital.model.ternary.DPT;
import project.hospital.model.ternary.RTI;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "treatment_procedure")
    private String treatmentProcedure;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private PrescriptionDetail prescriptionDetail;

    @OneToMany(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<ServiceDetail> serviceDetails;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private DPT dpt;

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getTreatmentProcedure() {
        return treatmentProcedure;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public PrescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public void setTreatmentProcedure(String treatmentProcedure) {
        this.treatmentProcedure = treatmentProcedure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
