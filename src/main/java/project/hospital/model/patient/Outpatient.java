package project.hospital.model.patient;

import jakarta.persistence.*;
import project.hospital.model.ternary.STO;

@Entity
@Table(name = "outpatient")
public class Outpatient extends Patient {

    @OneToOne(
            mappedBy = "outpatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private STO sto;

    public STO getSto() {
        return sto;
    }

    public void setSto(STO sto) {
        this.sto = sto;
    }
}
