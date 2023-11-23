package project.hospital.model.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import project.hospital.model.employee.HospitalDepartment;
@Entity
@Table(name = "Inpatient")
public class Inpatient extends Patient{

    @Column(name = "department")
    private HospitalDepartment department;

    @Column(name = "bed_cell")
    private String bedCell;

    @Column(name = "room")
    private String room;


}
