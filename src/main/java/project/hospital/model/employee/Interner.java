package project.hospital.model.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Interner")
public class Interner extends Employee {

    @Column(name = "university")
    private String university;

    public Interner(String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob, String university) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.university = university;
    }

    public Interner() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
