package project.hospital.model.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String employeeId;

    @Column(name = "working_room")
    protected String workingRoom;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getWorkingRoom() {
        return workingRoom;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setWorkingRoom(String workingRoom) {
        this.workingRoom = workingRoom;
    }
}
