package project.hospital.model.patient;

import jakarta.persistence.*;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "emergency_contact")
    private String emergencyContact;

//    @JoinColumn(name = "patient_id")
//    @OneToOne
//    private Inpatient inpatient;
}
