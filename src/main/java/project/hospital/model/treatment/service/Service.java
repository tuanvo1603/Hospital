package project.hospital.model.treatment.service;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_warehouse")
public class Service {

    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence_generator")
    @SequenceGenerator(name = "service_sequence_generator", sequenceName = "service_sequence", allocationSize = 1)
    private Long serviceId;

    @Column(name = "department")
    private String department;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "room_perform")
    private String roomPerform;

    public Long getServiceId() {
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

    public void setServiceId(Long serviceId) {
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

}
