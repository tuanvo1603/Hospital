package project.hospital.model.patient;

import jakarta.persistence.*;
import project.hospital.model.schedule.MedicineDispensation;

@Entity
@Table(name = "Inpatient")
public class Inpatient extends Patient{

    @Column(name = "department")
    private String department;

    @Column(name = "bed_cell")
    private Integer bedCell;

    @Column(name = "room")
    private String room;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private MedicineDispensation medicineDispensation;

    public String getDepartment() {
        return department;
    }

    public Integer getBedCell() {
        return bedCell;
    }

    public String getRoom() {
        return room;
    }

    public MedicineDispensation getMedicineDispensation() {
        return medicineDispensation;
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

    public void setMedicineDispensation(MedicineDispensation medicineDispensation) {
        this.medicineDispensation = medicineDispensation;
    }
}
