package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.repository.employee.ResidentDoctorRepository;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.employee.IEmployeeService;

@Service
public class ResidentDoctorService extends CommonEmployeeService implements IEmployeeService<ResidentDoctor> {

    private final ResidentDoctorRepository residentDoctorRepository;

    @Autowired
    public ResidentDoctorService(EmployeeRepository employeeRepository, ResidentDoctorRepository residentDoctorRepository) {
        super(employeeRepository);
        this.residentDoctorRepository = residentDoctorRepository;
    }

    @Override
    public ResidentDoctor createEmployee(ResidentDoctor residentDoctor) {
        return residentDoctorRepository.save(residentDoctor);
    }

    @Override
    public ResidentDoctor getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return residentDoctorRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void updateEmployee(Long employeeId, ResidentDoctor residentDoctor) {
        if(residentDoctorRepository.existsById(employeeId))
            residentDoctorRepository.save(residentDoctor);
        else
            throw new EmployeeNotFoundException();
    }

    @Override
    public void checkExistenceOfEmployee(Long employeeId) {
        if(!residentDoctorRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }
}
