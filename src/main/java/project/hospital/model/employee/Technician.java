package project.hospital.model.employee;

import jakarta.persistence.*;
import project.hospital.model.treatment.service.ServiceDetail;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Technician")
@Inheritance(strategy = InheritanceType.JOINED)
public class Technician extends Employee {

    @OneToMany(
            mappedBy = "technician",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ServiceDetail> serviceDetails;

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
