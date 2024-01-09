package project.hospital.model.employee;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department")
    private String department;

    @Column(name = "office_location")
    private String officeLocation;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

}
