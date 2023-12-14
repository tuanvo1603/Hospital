package project.hospital.service.employee.doctor.dean;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.service.schedule.WorkingScheduleService;
import project.hospital.service.ternary.RTIService;
import project.hospital.service.ternary.TernaryService;

import java.util.List;

@Service
public class DeanService {

    private final WorkingScheduleService workingScheduleService;

    private final EmployeeRepository employeeRepository;

    private final TernaryService ternaryService;

    @Autowired
    public DeanService(WorkingScheduleService workingScheduleService,
                       EmployeeRepository employeeRepository,
                       RTIService rtiService) {
        this.workingScheduleService = workingScheduleService;
        this.employeeRepository = employeeRepository;
        this.ternaryService = rtiService;
    }

    public void insertWorkingSchedule(List<WorkingSchedule> workingScheduleList) {
        workingScheduleService.insertWorkingSchedule(workingScheduleList);
    }

    @Transactional
    public void deleteWorkingScheduleForEmployee(Long employeeId) {
        workingScheduleService.deleteWorkingScheduleForEmployee(employeeId);
    }

    @Transactional
    public void setManagingDoctorForPatient(Long doctorId, Long patientId) throws PatientCanNotBeFoundException {
        ternaryService.setDoctorInTernary(doctorId, patientId);
    }

    public List<Employee> showDepartmentEmployees(String department) {
        return employeeRepository.showDepartmentEmployees(department);
    }

    private void saveEmployee(Employee employee) {
        employee.setWorkingSchedule(null);
        employeeRepository.save(employee);
    }

    public <T extends Employee> void insertEmployee(T t) {
        this.saveEmployee(t);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
