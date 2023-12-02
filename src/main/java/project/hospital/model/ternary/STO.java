package project.hospital.model.ternary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sto")
public class STO {

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
