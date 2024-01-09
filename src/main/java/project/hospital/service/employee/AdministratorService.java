package project.hospital.service.employee;

import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Administrator;
import project.hospital.repository.employee.AdministratorRepository;
import project.hospital.repository.employee.EmployeeRepository;

@Service
public class AdministratorService extends CommonEmployeeService implements IEmployeeService<Administrator>{

    private final AdministratorRepository administratorRepository;

    public AdministratorService(EmployeeRepository employeeRepository, AdministratorRepository administratorRepository) {
        super(employeeRepository);
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator createEmployee(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return administratorRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void updateEmployee(Long employeeId, Administrator administrator) {
        if(administratorRepository.existsById(employeeId))
            administratorRepository.save(administrator);
        else
            throw new EmployeeNotFoundException();
    }

    @Override
    public void checkExistenceOfEmployee(Long employeeId) {
        if(!administratorRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }
}
