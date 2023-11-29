package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;
import project.hospital.model.ternary.DPT;
import project.hospital.model.ternary.RTI;

import java.util.List;

@Entity
@Table(name = "Doctor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Doctor extends Employee {

    @Column(name = "qualifications")
    protected String qualifications;

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    protected List<DPT> dptList;

    public String getQualifications() {
        return qualifications;
    }

    public List<DPT> getDptList() {
        dptList.forEach(dpt -> {
            dpt.setDoctor(null);
            dpt.getPatient().setHospitalFee(null);
        });
        return dptList;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setDptList(List<DPT> dptList) {
        this.dptList = dptList;
    }
}
