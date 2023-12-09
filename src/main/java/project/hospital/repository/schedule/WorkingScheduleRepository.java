package project.hospital.repository.schedule;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.schedule.WorkingTime;

import java.sql.Date;

@Repository
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule, Long> {
}
