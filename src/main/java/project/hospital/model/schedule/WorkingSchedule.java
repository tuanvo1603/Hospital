package project.hospital.model.schedule;

import jakarta.persistence.*;
import project.hospital.model.employee.Employee;

import java.sql.Date;

@Entity
@Table(name = "working_schedule")
public class WorkingSchedule {

    @EmbeddedId
    private WorkingScheduleId workingScheduleId;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private Employee employee;

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkingScheduleId getWorkingScheduleId() {
        return workingScheduleId;
    }

    public void setWorkingScheduleId(WorkingScheduleId workingScheduleId) {
        this.workingScheduleId = workingScheduleId;
    }

    public enum WorkingTime {
        MORNING,
        AFTERNOON,
        FULLDAY,
        NIGHTSHIFT;
    }
}
