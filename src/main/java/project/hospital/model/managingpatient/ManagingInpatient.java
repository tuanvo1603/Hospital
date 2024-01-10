package project.hospital.model.managingpatient;

import jakarta.persistence.*;
import project.hospital.model.employee.Nurse;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.treatment.Treatment;

@Entity
@Table(name = "managing_inpatient")
public class ManagingInpatient extends ManagingPatient {
    @Column(name = "nurse_id")
    private Long nurseId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    @MapsId
    private Inpatient inpatient; 

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private ResidentDoctor residentDoctor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nurse_id", insertable = false, updatable = false)
    private Nurse nurse;

    public void setResidentDoctor(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public Inpatient getInpatient() {
        return inpatient;
    }

    public void setInpatient(Inpatient inpatient) {
        this.inpatient = inpatient;
    }

    public ResidentDoctor getResidentDoctor() {
        return residentDoctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }
}
