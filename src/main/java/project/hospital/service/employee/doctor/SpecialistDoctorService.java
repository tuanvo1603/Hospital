package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.repository.employee.SpecialistDoctorRepository;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.employee.IEmployeeService;

@Service
public class SpecialistDoctorService extends CommonEmployeeService implements IEmployeeService<SpecialistDoctor> {

    private final SpecialistDoctorRepository specialistDoctorRepository;

    @Autowired
    public SpecialistDoctorService(EmployeeRepository employeeRepository, SpecialistDoctorRepository specialistDoctorRepository) {
        super(employeeRepository);
        this.specialistDoctorRepository = specialistDoctorRepository;
    }

    @Override
    public SpecialistDoctor createEmployee(SpecialistDoctor specialistDoctor) {
        return specialistDoctorRepository.save(specialistDoctor);
    }

    @Override
    public SpecialistDoctor getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return specialistDoctorRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void updateEmployee(Long employeeId, SpecialistDoctor specialistDoctor) {
        if(specialistDoctorRepository.existsById(employeeId))
            specialistDoctorRepository.save(specialistDoctor);
        else
            throw new EmployeeNotFoundException();
    }

    @Override
    public void checkExistenceOfEmployee(Long employeeId) {
        if(!specialistDoctorRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }
}
