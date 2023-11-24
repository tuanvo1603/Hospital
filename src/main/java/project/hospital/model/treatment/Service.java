package project.hospital.model.treatment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
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

    @Column(name = "technician_id")
    private String technicianId;

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

    public String getTechnicianId() {
        return technicianId;
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

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }
}
