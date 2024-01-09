package project.hospital.model.managingpatient;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "appointment")
public class Appointment extends ManagingPatient {

    @Column(name = "date")
    private Date MeetingDate;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Outpatient outpatient;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private SpecialistDoctor specialistDoctor;

    public Outpatient getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Outpatient outpatient) {
        this.outpatient = outpatient;
    }

    public void setSpecialistDoctor(SpecialistDoctor specialistDoctor) {
        this.specialistDoctor = specialistDoctor;
    }

    public SpecialistDoctor getSpecialistDoctor() {
        return specialistDoctor;
    }

    public Date getMeetingDate() {
        return MeetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        MeetingDate = meetingDate;
    }
}
