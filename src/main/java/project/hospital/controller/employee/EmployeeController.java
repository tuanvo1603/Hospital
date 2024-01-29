package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.employee.GetEmployeeInfoByIdApi;
import project.hospital.api.patient.GetPatientByFullNameApi;
import project.hospital.api.treatment.medication.GetAllMedicationsApi;
import project.hospital.api.treatment.service.GetAllServicesApi;
import project.hospital.api.workingschedule.GetCurrentWeekWorkingScheduleApi;
import project.hospital.model.employee.Employee;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.request.employee.GetEmployeeInfoByIdRequest;
import project.hospital.request.patient.GetPatientByFullNameRequest;
import project.hospital.request.treatment.medication.GetAllMedicationsRequest;
import project.hospital.request.treatment.service.GetAllServicesRequest;
import project.hospital.request.workingschedule.GetCurrentWeekWorkingScheduleRequest;
import project.hospital.response.employee.GetEmployeeInfoByIdResponse;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.medication.GetAllMedicationsResponse;
import project.hospital.response.treatment.service.GetAllServicesResponse;
import project.hospital.response.workingschedule.GetCurrentWeekWorkingScheduleResponse;

import java.util.List;

@RestController
@RequestMapping("/employee")
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeController {

    private final GetEmployeeInfoByIdApi getEmployeeInfoByIdApi;

    private final GetCurrentWeekWorkingScheduleApi getCurrentWeekWorkingScheduleApi;

    private final GetAllMedicationsApi getAllMedicationsApi;

    private final GetAllServicesApi getAllServicesApi;

    private final GetPatientByFullNameApi getPatientByFullNameApi;

    public EmployeeController(GetEmployeeInfoByIdApi getEmployeeInfoByIdApi,
                              GetCurrentWeekWorkingScheduleApi getCurrentWeekWorkingScheduleApi,
                              GetAllMedicationsApi getAllMedicationsApi,
                              GetAllServicesApi getAllServicesApi,
                              GetPatientByFullNameApi getPatientByFullNameApi) {
        this.getEmployeeInfoByIdApi = getEmployeeInfoByIdApi;
        this.getCurrentWeekWorkingScheduleApi = getCurrentWeekWorkingScheduleApi;
        this.getAllMedicationsApi = getAllMedicationsApi;
        this.getAllServicesApi = getAllServicesApi;
        this.getPatientByFullNameApi = getPatientByFullNameApi;
    }


    @GetMapping("/check-schedule/{employeeId}")
    public GetCurrentWeekWorkingScheduleResponse checkWorkingSchedule(@PathVariable Long employeeId) {
        GetCurrentWeekWorkingScheduleRequest getCurrentWeekWorkingScheduleRequest = new GetCurrentWeekWorkingScheduleRequest(employeeId);
        return getCurrentWeekWorkingScheduleApi.execute(getCurrentWeekWorkingScheduleRequest);
    }

    @GetMapping("/check-my-information/{employeeId}")
    public GetEmployeeInfoByIdResponse checkMyInformation(@PathVariable Long employeeId) {
        GetEmployeeInfoByIdRequest getEmployeeInfoByIdRequest = new GetEmployeeInfoByIdRequest(employeeId);
        return getEmployeeInfoByIdApi.execute(getEmployeeInfoByIdRequest);
    }

    @GetMapping("/get-medication-list")
    public GetAllMedicationsResponse getMedicationList() {
        GetAllMedicationsRequest getAllMedicationsRequest = new GetAllMedicationsRequest();
        return getAllMedicationsApi.execute(getAllMedicationsRequest);
    }

    @GetMapping("/get-service-list")
    public GetAllServicesResponse getServiceList() {
        GetAllServicesRequest getAllServicesRequest = new GetAllServicesRequest();
        return getAllServicesApi.execute(getAllServicesRequest);
    }

    @GetMapping("/{administratorId}/search-by-name/{firstName}/{lastName}")
    public GetPatientsResponse searchPatientByName(@PathVariable Long administratorId,
                                                   @PathVariable String firstName,
                                                   @PathVariable String lastName) {
        GetPatientByFullNameRequest getPatientByFullNameRequest = new GetPatientByFullNameRequest(administratorId, firstName, lastName);
        return getPatientByFullNameApi.execute(getPatientByFullNameRequest);
    }
}
