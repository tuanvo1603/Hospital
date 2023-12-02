package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.repository.schedule.WorkingScheduleRepository;

import java.util.ArrayList;

@Service
public class DeanService {

    private final WorkingScheduleRepository workingScheduleRepository;

    @Autowired
    public DeanService(WorkingScheduleRepository workingScheduleRepository) {
        this.workingScheduleRepository = workingScheduleRepository;
    }

    public void insertWorkingSchedule(@RequestBody ArrayList<WorkingSchedule> workingScheduleList) {
        workingScheduleList.forEach(workingScheduleRepository::save);
    }
}
