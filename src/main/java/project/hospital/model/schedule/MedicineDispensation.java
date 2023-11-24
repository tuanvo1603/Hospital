package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.patient.Inpatient;

import java.sql.Date;

@Entity
@Table(name = "medicine_dispensation")
public class MedicineDispensation {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "date")
    private Date date;

    @Column(name = "half_a_day")
    @Enumerated(EnumType.STRING)
    private HalfADay halfADay;

    public enum HalfADay {
        Sáng,
        Chiều
    }

    @Column(name = "treatment_id")
    private String treatmentId;

    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "patient_id"
    )
    @OneToOne
    private Inpatient inpatient;

}
