package project.hospital.model.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.sql.Date;

@Embeddable
public class WorkingScheduleId implements Serializable {
    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "start_week_date")
    private Date startWeekDate;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartWeekDate() {
        return startWeekDate;
    }

    public void setStartWeekDate(Date startWeekDate) {
        this.startWeekDate = startWeekDate;
    }
}
