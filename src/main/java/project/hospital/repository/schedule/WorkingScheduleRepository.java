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
public interface WorkingScheduleRepository extends JpaRepository<WorkingSchedule, String> {
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO working_schedule(emp_id, week_start_date, monday, tuesday, wednesday, thursday, friday, saturday, sunday)" +
//                    "VALUES(:employeeId, :weekStartDate, :monday, :tuesday, :wednesday, :thursday, :friday, :saturday, :sunday)",
//            nativeQuery = true)
//    void saveSchedule(
//            @Param("employeeId") String employeeId,
//            @Param("weekStartDate") Date weekStartDate,
//            @Param("monday") WorkingTime monday,
//            @Param("tuesday") WorkingTime tuesday,
//            @Param("wednesday") WorkingTime wednesday,
//            @Param("thursday") WorkingTime thursday,
//            @Param("friday") WorkingTime friday,
//            @Param("saturday") WorkingTime saturday,
//            @Param("sunday") WorkingTime sunday
//    );

}
