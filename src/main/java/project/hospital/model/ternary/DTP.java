package project.hospital.model.ternary;

import jakarta.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DTP {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "treatment_id")
    private Long treatmentId;

    public Long getPatientId() {
        return patientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }
}
