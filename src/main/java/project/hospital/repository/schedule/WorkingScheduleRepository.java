package project.hospital.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.schedule.WorkingSchedule;

import java.sql.Date;

@Repository
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule, Long> {

    WorkingSchedule findByEmployeeIdAndAndWeekStartDate(Long employeeId, Date weekStartDate);
}
