package project.hospital.model.treatment.service;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_warehouse")
public class Service {

    @Id
    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "department")
    private String department;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "room_perform")
    private String roomPerform;

    @OneToMany(
            mappedBy = "service",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ServiceDetail> serviceDetails;

    public String getServiceId() {
        return serviceId;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public String getRoomPerform() {
        return roomPerform;
    }

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setRoomPerform(String roomPerform) {
        this.roomPerform = roomPerform;
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
