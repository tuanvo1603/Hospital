package project.hospital.service.employee;

import org.springframework.stereotype.Service;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.employee.Technician;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.repository.employee.TechnicianRepository;

@Service
public class TechnicianService extends CommonEmployeeService implements IEmployeeService<Technician> {

    private final TechnicianRepository technicianRepository;

    public TechnicianService(EmployeeRepository employeeRepository, TechnicianRepository technicianRepository) {
        super(employeeRepository);
        this.technicianRepository = technicianRepository;
    }

    @Override
    public Technician createEmployee(Technician technician) {
        return technicianRepository.save(technician);
    }

    @Override
    public Technician getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return technicianRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void updateEmployee(Long employeeId, Technician technician) {
        if(technicianRepository.existsById(employeeId))
            technicianRepository.save(technician);
        else
            throw new EmployeeNotFoundException();
    }

    @Override
    public void checkExistenceOfEmployee(Long employeeId) {
        if(!technicianRepository.existsById(employeeId))
            throw new EmployeeNotFoundException();
    }
}
