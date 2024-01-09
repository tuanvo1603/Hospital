package project.hospital.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.repository.schedule.WorkingScheduleRepository;
import project.hospital.service.DateService;
import project.hospital.service.employee.CommonEmployeeService;

import java.util.List;

@Service
public class WorkingScheduleService {

    private final WorkingScheduleRepository workingScheduleRepository;

    private final DateService dateService;

    private final CommonEmployeeService commonEmployeeService;

    @Autowired
    public WorkingScheduleService(WorkingScheduleRepository workingScheduleRepository,
                                  DateService dateService,
                                  CommonEmployeeService commonEmployeeService) {
        this.workingScheduleRepository = workingScheduleRepository;
        this.dateService = dateService;
        this.commonEmployeeService = commonEmployeeService;
    }

    private void initWorkingSchedule(WorkingSchedule workingSchedule) {
        commonEmployeeService.checkExistenceOfEmployee(workingSchedule.getEmployeeId());
        workingSchedule.setWeekStartDate(dateService.getStartDateOfThisWeek());
    }

    public void initWorkingScheduleList(List<WorkingSchedule> workingScheduleList) {
        workingScheduleList.forEach(this::initWorkingSchedule);
        workingScheduleRepository.saveAll(workingScheduleList);
    }

    public void updateWorkingSchedule(WorkingSchedule workingSchedule) {
        workingScheduleRepository.save(workingSchedule);
    }

    public void deleteWorkingSchedule(Long employeeId) {
        workingScheduleRepository.deleteById(employeeId);
    }

    public WorkingSchedule getCurrentWeekWorkingSchedule(Long employeeId) {
        return workingScheduleRepository.findByEmployeeIdAndAndWeekStartDate(employeeId, dateService.getStartDateOfThisWeek());
    }
}
