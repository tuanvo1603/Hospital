package project.hospital.model.treatment.service;

import jakarta.persistence.*;
import project.hospital.model.employee.Technician;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service_detail")
public class ServiceDetail {

    @Id
    @Column(name = "treatment_id")
    private Long treatmentId;

    @Column(name = "time_perform")
    private Date timePerform;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "technician_id")
    private Long technicianId;

    @Column(name = "conclusion")
    private String conclusion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    public Date getTimePerform() {
        return timePerform;
    }

    public String getConclusion() {
        return conclusion;
    }

    public Service getService() {
        return service;
    }

    public void setTimePerform(Date timePerform) {
        this.timePerform = timePerform;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }
}
