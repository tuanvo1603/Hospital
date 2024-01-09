package project.hospital.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import project.hospital.model.treatment.service.ServiceDetail;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Technician")
public class Technician extends Employee {
}
