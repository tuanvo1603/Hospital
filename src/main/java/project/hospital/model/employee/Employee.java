package project.hospital.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.hospital.model.schedule.WorkingSchedule;

import java.time.LocalDate;

@Entity
@Table(name = "emp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long employeeId;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "dob")
    protected LocalDate dob;

    @Column(name = "department")
    protected String department;

    @Column(name = "working_room")
    protected String workingRoom;

    @Column(name = "qualifications")
    protected String qualifications;

    @OneToOne(
            mappedBy = "employee",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JsonIgnore
    protected WorkingSchedule workingSchedule;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department", insertable=false, updatable=false)
    @JsonIgnore
    private Department departmentEntity;

    public Long getEmployeeId() {
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

    public WorkingSchedule getWorkingSchedule() {
        return workingSchedule;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setEmployeeId(Long employeeId) {
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

    public void setWorkingRoom(String workingRoom) {
        this.workingRoom = workingRoom;
    }

    public void setWorkingSchedule(WorkingSchedule workingSchedule) {
        this.workingSchedule = workingSchedule;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Department getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(Department departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
}
