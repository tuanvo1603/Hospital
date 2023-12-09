package project.hospital.model.patient;

import jakarta.persistence.*;
import project.hospital.model.schedule.MedicineDispensation;
import project.hospital.model.ternary.RTI;
import project.hospital.model.treatment.HospitalFee;

@Entity
@Table(name = "Inpatient")
public class Inpatient extends Patient {

    @Column(name = "department")
    private String department;

    @Column(name = "bed_cell")
    private Integer bedCell;

    @Column(name = "room")
    private String room;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private MedicineDispensation medicineDispensation;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Family family;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private RTI rti;

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

    public Family getFamily() {
        return family;
    }

    public RTI getRti() {
        return rti;
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

    public void setRti(RTI rti) {
        this.rti = rti;
    }

    public void setFamily(Family family) {
        this.family = family;
    }



}
