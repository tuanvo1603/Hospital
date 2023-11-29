package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public void insertWorkingSchedule(ArrayList<WorkingSchedule> workingScheduleList) {
        workingScheduleList.forEach(workingScheduleRepository::save);
    }

    public void updateWorkingSchedule(ArrayList<WorkingSchedule> workingScheduleList) {
        workingScheduleList.forEach(workingSchedule -> {
                                                        workingScheduleRepository.deleteById(workingSchedule.getEmployeeId());
                                                        workingScheduleRepository.save(workingSchedule);
                                                        });
    }

//    public void updateManagingTreatment(ArrayList<Object> objectUpdated) {
//        objectUpdated.get(0)
    //To-do
//    }
}
