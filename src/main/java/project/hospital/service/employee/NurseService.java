package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Nurse;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.repository.employee.NurseRepository;

@Service
public class NurseService extends CommonEmployeeService implements IEmployeeService<Nurse>{

    private final NurseRepository nurseRepository;

    @Autowired
    public NurseService(EmployeeRepository employeeRepository, NurseRepository nurseRepository) {
        super(employeeRepository);
        this.nurseRepository = nurseRepository;
    }

    @Override
    public Nurse createEmployee(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return nurseRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void updateEmployee(Long employeeId, Nurse nurse) {
        if(nurseRepository.existsById(employeeId))
            nurseRepository.save(nurse);
        else
            throw new EmployeeNotFoundException();
    }

    @Override
    public void checkExistenceOfEmployee(Long employeeId) {
        if(!nurseRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }
}
