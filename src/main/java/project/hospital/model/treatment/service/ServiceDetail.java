package project.hospital.model.treatment.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "service_detail")
public class ServiceDetail {

    @Id
    @Column(name = "service_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceDetailId;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "time_perform")
    private Date timePerform;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "technician_id")
    @Nonnull
    private Long technicianId;

    @Column(name = "conclusion")
    @Nonnull
    private String conclusion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    @JsonIgnore
    private HospitalServiceEntity hospitalServiceEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    @JsonBackReference
    private Treatment treatment;

    public Long getServiceDetailId() {
        return serviceDetailId;
    }

    public void setServiceDetailId(Long serviceDetailId) {
        this.serviceDetailId = serviceDetailId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Date getTimePerform() {
        return timePerform;
    }

    public void setTimePerform(Date timePerform) {
        this.timePerform = timePerform;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Nonnull
    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(@Nonnull Long technicianId) {
        this.technicianId = technicianId;
    }

    @Nonnull
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(@Nonnull String conclusion) {
        this.conclusion = conclusion;
    }

    public HospitalServiceEntity getHospitalServiceEntity() {
        return hospitalServiceEntity;
    }

    public void setHospitalServiceEntity(HospitalServiceEntity hospitalServiceEntity) {
        this.hospitalServiceEntity = hospitalServiceEntity;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
