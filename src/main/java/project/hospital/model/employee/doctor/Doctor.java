package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;
import project.hospital.model.employee.HospitalDepartment;

import java.time.LocalDate;

@Entity
@Table(name = "Doctor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends Employee {

    @Column(name = "qualifications")
    private String qualifications;

    public Doctor(String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob, String qualifications) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.qualifications = qualifications;
    }

    public Doctor() {
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
