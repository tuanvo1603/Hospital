package project.hospital.model.employee.doctor;

import jakarta.persistence.*;

@Entity
@Table(name = "specialist_doctor")
public class SpecialistDoctor extends Doctor {
//
//    @OneToMany(
//            mappedBy = "specialistDoctor",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JsonIgnore
//    private List<STO> stos;
//
//    public List<STO> getStos() {
//        return stos;
//    }
//
//    public void setStos(List<STO> stos) {
//        this.stos = stos;
//    }
}
