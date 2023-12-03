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
    private String treatmentId;

    @Column(name = "time_perform")
    private Date timePerform;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "technician_id")
    private String technicianId;

    @Column(name = "conclusion")
    private String conclusion;

    @ManyToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "technician_id", insertable = false, updatable = false)
    private Technician technician;

    public Date getTimePerform() {
        return timePerform;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setTimePerform(Date timePerform) {
        this.timePerform = timePerform;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
