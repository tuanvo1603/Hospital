package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.ternary.RTI;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resident_doctor")
public class ResidentDoctor extends Doctor{

    @Id
    @Column(name = "emp_id")
    private String employeeId;

    @OneToMany(
            mappedBy = "residentDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RTI> rtiSet;

    public List<RTI> getRtiSet() {
        return rtiSet;
    }

    public void setRtiSet(ArrayList<RTI> rtiSet) {
        this.rtiSet = rtiSet;
    }
}
