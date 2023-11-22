package project.hospital.model.employee;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Doctor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Doctor extends Employee {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "department")
    private String department;

    @Column(name = "qualifications")
    private String qualifications;

    public Doctor(String employeeId, String workingRoom, String firstName, String lastName, LocalDate dob, String department, String qualifications) {
        super(employeeId, workingRoom);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.department = department;
        this.qualifications = qualifications;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getDepartment() {
        return department;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
