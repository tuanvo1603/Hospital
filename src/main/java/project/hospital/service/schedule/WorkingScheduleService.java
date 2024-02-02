package project.hospital.service.schedule;

import org.springframework.stereotype.Service;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.schedule.WorkingScheduleId;
import project.hospital.repository.schedule.WorkingScheduleRepository;
import project.hospital.service.DateService;

import java.util.List;

@Service
public class WorkingScheduleService {

    private final WorkingScheduleRepository workingScheduleRepository;

    private final DateService dateService;

    public WorkingScheduleService(WorkingScheduleRepository workingScheduleRepository,
                                  DateService dateService) {
        this.workingScheduleRepository = workingScheduleRepository;
        this.dateService = dateService;
    }

    public void initWorkingSchedule(WorkingSchedule workingSchedule) {
        if(workingScheduleRepository.existsById(workingSchedule.getWorkingScheduleId().getEmployeeId(), dateService.getStartDateOfThisWeek())) {
            workingSchedule.getWorkingScheduleId().setStartWeekDate(dateService.getStartDateOfThisWeek());
            updateWorkingSchedule(workingSchedule);
        }
        WorkingScheduleId workingScheduleId = new WorkingScheduleId();
        workingScheduleId.setEmployeeId(workingSchedule.getWorkingScheduleId().getEmployeeId());
        workingScheduleId.setStartWeekDate(dateService.getStartDateOfThisWeek());
        workingSchedule.setWorkingScheduleId(workingScheduleId);
    }

    public void initWorkingScheduleList(List<WorkingSchedule> workingScheduleList) {
        workingScheduleList.forEach(this::initWorkingSchedule);
        workingScheduleRepository.saveAll(workingScheduleList);
    }

    public void updateWorkingSchedule(WorkingSchedule workingSchedule) {
        workingScheduleRepository.save(workingSchedule);
    }

    public void deleteWorkingSchedule(Long employeeId) {
        workingScheduleRepository.deleteByEmployeeId(employeeId, dateService.getStartDateOfThisWeek());
    }

    public WorkingSchedule getCurrentWeekWorkingSchedule(Long employeeId) {
        return workingScheduleRepository.findByWorkingScheduleId(employeeId, dateService.getStartDateOfThisWeek());
    }
}
