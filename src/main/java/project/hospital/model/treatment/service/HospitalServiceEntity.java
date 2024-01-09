package project.hospital.model.treatment.service;

import jakarta.persistence.*;

@Entity
@Table(name = "service_warehouse")
public class HospitalServiceEntity {

    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
