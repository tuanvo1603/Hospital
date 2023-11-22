package project.hospital.model.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @Column(name = "emp_id")
    protected String employeeId;

    @Column(name = "working_room")
    protected String workingRoom;

    public Employee(String employeeId, String workingRoom) {
        this.employeeId = employeeId;
        this.workingRoom = workingRoom;
    }

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
