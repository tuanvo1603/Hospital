package project.hospital.model.treatment.service;

import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    @OneToMany(
            mappedBy = "serviceDetail",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<ServiceList> serviceLists = new HashSet<>();

    public String getTreatmentId() {
        return treatmentId;
    }

    public Date getTimePerform() {
        return timePerform;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public Set<ServiceList> getServiceLists() {
        return serviceLists;
    }


    public void setTimePerform(Date timePerform) {
        this.timePerform = timePerform;
    }

    public void setServiceLists(Set<ServiceList> serviceLists) {
        this.serviceLists = serviceLists;
    }
}
