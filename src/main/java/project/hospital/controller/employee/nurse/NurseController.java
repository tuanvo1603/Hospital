package project.hospital.controller.employee.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.model.employee.Nurse;
import project.hospital.model.schedule.MedicineDispensation;
import project.hospital.service.employee.nurse.NurseService;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    private final NurseService nurseService;
    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/list-medicine-dispensation")
    public List<MedicineDispensation> getListMedicineDispensation(Nurse nurse) {
        return nurseService.getListMedicineDispensation(nurse);
    }

}
