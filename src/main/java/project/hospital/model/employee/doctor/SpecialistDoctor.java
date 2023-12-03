package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.ternary.RTI;
import project.hospital.model.ternary.STO;

import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "specialist_doctor")
public class SpecialistDoctor extends Doctor {

    @OneToMany(
            mappedBy = "specialistDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<STO> stos;

    public List<STO> getStos() {
        stos.forEach(sto -> {
            sto.setSpecialistDoctor(null);
            sto.setOutpatient(null);
        });
        return stos;
    }

    public void setStos(List<STO> stos) {
        this.stos = stos;
    }
}
