package project.hospital.model.employee.doctor;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;

@Entity
@Table(name = "Doctor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor extends Employee {
}
