package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;

@Entity
@Table(name = "Doctor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Doctor extends Employee {
}
