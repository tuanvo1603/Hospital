package project.hospital.model.treatment;

import jakarta.persistence.*;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.sql.Date;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "treatment_procedure")
    private String treatmentProcedure;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL)
    private PrescriptionDetail prescriptionDetail;
}
