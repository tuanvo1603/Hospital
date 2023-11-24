package project.hospital.service.employee.secretary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.repository.secretary.SecretaryRepository;

@Service
public class ManagingEmployeeService {

    private final SecretaryRepository secretaryRepository;

    @Autowired
    public ManagingEmployeeService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    public void deleteEmployee(String employeeId) {
        secretaryRepository.deleteById(employeeId);
    }

    public void insertDoctor(Doctor doctor) {
        secretaryRepository.save(doctor);
    }

    public void insertTechnician(Technician technician) {
        secretaryRepository.save(technician);
    }

    public void insertNurse(Nurse nurse) {
        secretaryRepository.save(nurse);
    }

    public void insertAdministrator(Administrator administrator) {
        secretaryRepository.save(administrator);
    }

    public void insertInterner(Interner interner) {
        secretaryRepository.save(interner);
    }

}
