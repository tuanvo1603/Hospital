package project.hospital.model.employee;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private HospitalDepartment department;

    @Column(name = "office_location")
    private String officeLocation;

    @OneToMany(
            mappedBy = "departmentObject",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employee> Employees;

    public HospitalDepartment getDepartment() {
        return department;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public Set<Employee> getEmployees() {
        return Employees;
    }

    public void setDepartment(HospitalDepartment department) {
        this.department = department;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void setEmployees(Set<Employee> employees) {
        Employees = employees;
    }

}
