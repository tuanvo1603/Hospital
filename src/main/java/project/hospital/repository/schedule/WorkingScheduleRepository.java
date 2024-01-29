package project.hospital.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.schedule.WorkingScheduleId;

import java.sql.Date;

@Repository
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule, WorkingScheduleId> {

    @Query("SELECT w FROM WorkingSchedule w WHERE w.workingScheduleId.employeeId = :employeeId AND w.workingScheduleId.startWeekDate = :weekStartDate")
    WorkingSchedule findByWorkingScheduleId(@Param("employeeId") Long employeeId, @Param("weekStartDate") Date weekStartDate);

    @Modifying
    @Transactional
    @Query("DELETE FROM WorkingSchedule w WHERE w.workingScheduleId.employeeId = :employeeId AND w.workingScheduleId.startWeekDate = :weekStartDate")
    void deleteByEmployeeId(@Param("employeeId") Long employeeId, @Param("weekStartDate") Date weekStartDate);

    @Query("SELECT COUNT(w) > 0 FROM WorkingSchedule w WHERE w.workingScheduleId.employeeId = :employeeId AND w.workingScheduleId.startWeekDate = :weekStartDate")
    boolean existsById(@Param("employeeId") Long employeeId, @Param("weekStartDate") Date weekStartDate);
}
