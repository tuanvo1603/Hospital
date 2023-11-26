package project.hospital.model.treatment.service;

import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "service_detail")
public class ServiceDetail {

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

    @Column(name = "time_perform")
    private Date timePerform;

    @OneToOne
    @JoinColumn(
            name = "treatment_id",
            referencedColumnName = "treatment_id")
    private Treatment treatment;
}
