package project.hospital.model.treatment.service;

import jakarta.persistence.*;

@Entity
@Table(name = "service_list")
public class ServiceList {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "technician_id")
    private String technicianId;

    @Column(name = "conclusion")
    private String conclusion;

    @ManyToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private ServiceDetail serviceDetail;

    @ManyToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Service service;

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public String getConclusion() {
        return conclusion;
    }

    public Service getService() {
        return service;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
