package project.hospital.model.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Administrator")
public class Administrator extends Employee {

    public Administrator(String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Administrator() {
    }
}
