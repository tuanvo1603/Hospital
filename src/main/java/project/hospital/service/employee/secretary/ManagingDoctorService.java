package project.hospital.service.employee.secretary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.Doctor;
import project.hospital.repository.secretary.SecretaryRepository;

@Service
public class ManagingDoctorService {

    private final SecretaryRepository secretaryRepository;
    @Autowired
    public ManagingDoctorService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    public void insertEmployee(Doctor doctor) {
        secretaryRepository.save(doctor);
    }
}
