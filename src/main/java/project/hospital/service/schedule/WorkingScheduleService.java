package project.hospital.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.repository.schedule.WorkingScheduleRepository;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class WorkingScheduleService {
    private final WorkingScheduleRepository workingScheduleRepository;

    @Autowired
    public WorkingScheduleService(WorkingScheduleRepository workingScheduleRepository) {
        this.workingScheduleRepository = workingScheduleRepository;
    }

    public Date getFirstDateOfCurrentWeek() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDateOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return Date.valueOf(firstDateOfWeek);
    }

    public WorkingSchedule addWorkingSchedule(Employee employee) {
        WorkingSchedule workingSchedule = new WorkingSchedule();
        workingSchedule.setEmployeeId(employee.getEmployeeId());
        workingSchedule.setWeekStartDate(this.getFirstDateOfCurrentWeek());
        return workingSchedule;
    }

    public void insertWorkingSchedule(List<WorkingSchedule> workingScheduleList) {
        workingScheduleRepository.saveAll(workingScheduleList);
    }

    public void deleteWorkingScheduleForEmployee(Long employeeId) {
        workingScheduleRepository.deleteById(employeeId);
    }
}
