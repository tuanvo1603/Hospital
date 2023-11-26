package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;

import java.sql.Date;

@Entity
@Table(name = "working_schedule")
public class WorkingSchedule {

    @Id
    @Column(name = "emp_id")
    private String employeeId;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Column(name = "week_start_date")
    private Date weekStartDate;

    @Column(name = "monday")
    @Enumerated(EnumType.STRING)
    private WorkingTime monday;

    @Column(name = "tuesday")
    @Enumerated(EnumType.STRING)
    private WorkingTime tuesday;

    @Column(name = "wednesday")
    @Enumerated(EnumType.STRING)
    private WorkingTime wednesday;

    @Column(name = "thursday")
    @Enumerated(EnumType.STRING)
    private WorkingTime thursday;

    @Column(name = "friday")
    @Enumerated(EnumType.STRING)
    private WorkingTime friday;

    @Column(name = "saturday")
    @Enumerated(EnumType.STRING)
    private WorkingTime saturday;

    @Column(name = "sunday")
    @Enumerated(EnumType.STRING)
    private WorkingTime sunday;
}
