package project.hospital.model.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.hospital.model.managingpatient.Appointment;

@Entity
@Table(name = "outpatient")
public class Outpatient extends Patient {

    @OneToOne(
            mappedBy = "outpatient",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Appointment appointment;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
