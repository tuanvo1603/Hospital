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

    public String getEmployeeId() {
        return employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public WorkingTime getMonday() {
        return monday;
    }

    public WorkingTime getTuesday() {
        return tuesday;
    }

    public WorkingTime getWednesday() {
        return wednesday;
    }

    public WorkingTime getThursday() {
        return thursday;
    }

    public WorkingTime getFriday() {
        return friday;
    }

    public WorkingTime getSaturday() {
        return saturday;
    }

    public WorkingTime getSunday() {
        return sunday;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public void setMonday(WorkingTime monday) {
        this.monday = monday;
    }

    public void setTuesday(WorkingTime tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(WorkingTime wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(WorkingTime thursday) {
        this.thursday = thursday;
    }

    public void setFriday(WorkingTime friday) {
        this.friday = friday;
    }

    public void setSaturday(WorkingTime saturday) {
        this.saturday = saturday;
    }

    public void setSunday(WorkingTime sunday) {
        this.sunday = sunday;
    }
}
