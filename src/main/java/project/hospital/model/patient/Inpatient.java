package project.hospital.model.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.hospital.model.managingpatient.ManagingInpatient;

@Entity
@Table(name = "Inpatient")
public class Inpatient extends Patient {

    @Column(name = "department")
    private String department;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private ManagingInpatient managingInpatient;

    @OneToOne(
            mappedBy = "inpatient",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Family family;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ManagingInpatient getManagingInpatient() {
        return managingInpatient;
    }

    public void setManagingInpatient(ManagingInpatient managingInpatient) {
        this.managingInpatient = managingInpatient;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
