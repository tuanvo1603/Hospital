package project.hospital.model.employee.doctor;

import jakarta.persistence.*;

@Entity
@Table(name = "resident_doctor")
public class ResidentDoctor extends Doctor {
//
//    @OneToMany(
//            mappedBy = "residentDoctor",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JsonManagedReference("resident-rti")
//    @JsonIgnore
//    protected List<RTI> rtis = new ArrayList<>();
//
//    public List<RTI> getRtis() {
//        return rtis;
//    }
//
//    public void setDptList(List<RTI> rtis) {
//        this.rtis = rtis;
//    }
}
