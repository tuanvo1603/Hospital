package project.hospital.model.ternary;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.treatment.Treatment;

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

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Inpatient inpatient;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private ResidentDoctor residentDoctor;

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    public Inpatient getInpatient() {
        return inpatient;
    }

    public Treatment getTreatment() {
        return treatment;
    }

//    public ResidentDoctor getResidentDoctor() {
//        return residentDoctor;
//    }

    public void setResidentDoctor(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public void setInpatient(Inpatient inpatient) {
        this.inpatient = inpatient;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
