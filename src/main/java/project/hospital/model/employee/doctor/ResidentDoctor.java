package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.ternary.RTI;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resident_doctor")
public class ResidentDoctor extends Doctor {

    @OneToMany(
            mappedBy = "residentDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    protected List<RTI> rtis = new ArrayList<>();

    public List<RTI> getRtis() {
        rtis.forEach(rti -> {
            rti.setResidentDoctor(null);
//            rti.getInpatient().setHospitalFee(null);
        });
        return rtis;
    }

    public void setDptList(List<RTI> rtis) {
        this.rtis = rtis;
    }
}
