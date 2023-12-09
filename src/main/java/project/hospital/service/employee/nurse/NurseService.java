package project.hospital.service.employee.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.Nurse;
import project.hospital.model.schedule.MedicineDispensation;
import project.hospital.repository.patient.PatientDTORepository;

import java.util.List;

@Service
public class NurseService {

    private final PatientDTORepository patientDTORepository;

    @Autowired
    public NurseService(PatientDTORepository patientDTORepository) {
        this.patientDTORepository = patientDTORepository;
    }

    public List<MedicineDispensation> getListMedicineDispensation(Nurse nurse) {
        return nurse.getMedicineDispensations();
    }
}
