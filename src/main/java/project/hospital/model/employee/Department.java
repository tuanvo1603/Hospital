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

    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employee> Employees;

    public String getDepartment() {
        return department;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public Set<Employee> getEmployees() {
        return Employees;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void setEmployees(Set<Employee> employees) {
        Employees = employees;
    }

}
