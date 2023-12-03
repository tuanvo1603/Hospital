package project.hospital.model.employee;

import jakarta.persistence.*;
import project.hospital.model.schedule.MedicineDispensation;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Nurse")
@Inheritance(strategy = InheritanceType.JOINED)
public class Nurse extends Employee {

    @OneToMany(
            mappedBy = "nurse",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<MedicineDispensation> medicineDispensations;

    public List<MedicineDispensation> getMedicineDispensations() {
        return medicineDispensations;
    }

    public void setMedicineDispensations(List<MedicineDispensation> medicineDispensations) {
        this.medicineDispensations = medicineDispensations;
    }
}
