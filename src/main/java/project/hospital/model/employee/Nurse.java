package project.hospital.model.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Nurse")
public class Nurse extends Employee {

    @Column(name = "qualifications")
    private String qualifications;

    public Nurse(String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob, String qualifications) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.qualifications = qualifications;
    }

    public Nurse() {
    }

    public String getQualifications() {
        return qualifications;
    }


    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
