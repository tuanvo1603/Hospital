package project.hospital.model.employee;

import jakarta.persistence.*;
import project.hospital.model.schedule.WorkingSchedule;

import java.time.LocalDate;

@Entity
@Table(name = "emp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @Column(name = "emp_id")
    protected String employeeId;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "dob")
    protected LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department departmentObject;

    @Column(name = "working_room")
    protected String workingRoom;

    @OneToOne(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private WorkingSchedule workingSchedule;

    public String getEmployeeId() {
        return employeeId;
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


    public String getWorkingRoom() {
        return workingRoom;
    }

    public Department getDepartmentObject() {
        return departmentObject;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public void setDepartmentObject(Department departmentObject) {
        this.departmentObject = departmentObject;
    }

    public void setWorkingRoom(String workingRoom) {
        this.workingRoom = workingRoom;
    }
}
