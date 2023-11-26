package project.hospital.model.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Technician")
public class Technician extends Employee {

    @Column(name = "qualifications")
    private String qualifications;

    public Technician(
            String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob, String qualifications) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.qualifications = qualifications;
    }

    public Technician() {
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
