package project.hospital.model.ternary;

import jakarta.persistence.*;

@Entity
@Table(name = "rti")
public class RTI {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Id
    @Column(name = "emp_id")
    private String employeeId;

    @Id
    @Column(name = "treatment_id")
    private String treatmentId;

}
