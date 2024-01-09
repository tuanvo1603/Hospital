package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;

import java.sql.Date;

@Entity
@Table(name = "working_schedule")
public class WorkingSchedule {

    @Id
    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "week_start_date")
    private Date weekStartDate;

    @Column(name = "monday")
    private WorkingTime monday;

    @Column(name = "tuesday")
    private WorkingTime tuesday;

    @Column(name = "wednesday")
    private WorkingTime wednesday;

    @Column(name = "thursday")
    private WorkingTime thursday;

    @Column(name = "friday")
    private WorkingTime friday;

    @Column(name = "saturday")
    private WorkingTime saturday;

    @Column(name = "sunday")
    private WorkingTime sunday;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    @MapsId
    private Employee employee;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public WorkingTime getMonday() {
        return monday;
    }

    public void setMonday(WorkingTime monday) {
        this.monday = monday;
    }

    public WorkingTime getTuesday() {
        return tuesday;
    }

    public void setTuesday(WorkingTime tuesday) {
        this.tuesday = tuesday;
    }

    public WorkingTime getWednesday() {
        return wednesday;
    }

    public void setWednesday(WorkingTime wednesday) {
        this.wednesday = wednesday;
    }

    public WorkingTime getThursday() {
        return thursday;
    }

    public void setThursday(WorkingTime thursday) {
        this.thursday = thursday;
    }

    public WorkingTime getFriday() {
        return friday;
    }

    public void setFriday(WorkingTime friday) {
        this.friday = friday;
    }

    public WorkingTime getSaturday() {
        return saturday;
    }

    public void setSaturday(WorkingTime saturday) {
        this.saturday = saturday;
    }

    public WorkingTime getSunday() {
        return sunday;
    }

    public void setSunday(WorkingTime sunday) {
        this.sunday = sunday;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public enum WorkingTime {
        MORNING,
        AFTERNOON,
        FULLDAY,
        NIGHTSHIFT;
    }
}
