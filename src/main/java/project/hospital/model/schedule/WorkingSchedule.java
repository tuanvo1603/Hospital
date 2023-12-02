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

    @Column(name = "week_start_date")
    private Date weekStartDate;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public String getEmployeeId() {
        return employeeId;
    }

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public String getFriday() {
        return friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
