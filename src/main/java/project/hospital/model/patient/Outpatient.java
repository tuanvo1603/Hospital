package project.hospital.model.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "outpatient")
public class Outpatient extends Patient {
}
