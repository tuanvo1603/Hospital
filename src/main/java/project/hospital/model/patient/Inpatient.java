package project.hospital.model.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import project.hospital.model.employee.HospitalDepartment;
import project.hospital.model.employee.Interner;

@Entity
@Table(name = "Inpatient")
public class Inpatient extends Patient{

    @Column(name = "department")
    private String department;

    @Column(name = "bed_cell")
    private Integer bedCell;

    @Column(name = "room")
    private String room;

    public String getDepartment() {
        return department;
    }

    public Integer getBedCell() {
        return bedCell;
    }

    public String getRoom() {
        return room;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBedCell(Integer bedCell) {
        this.bedCell = bedCell;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
