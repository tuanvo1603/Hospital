package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.employee.GetEmployeeInfoByIdApi;
import project.hospital.api.patient.GetPatientByFullNameApi;
import project.hospital.api.treatment.medication.GetMedicationsApi;
import project.hospital.api.treatment.service.GetServicesApi;
import project.hospital.api.workingschedule.GetCurrentWeekWorkingScheduleApi;
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

@RestController
@RequestMapping("/v1/employee")
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeController {

    private final GetEmployeeInfoByIdApi getEmployeeInfoByIdApi;

    private final GetCurrentWeekWorkingScheduleApi getCurrentWeekWorkingScheduleApi;

    private final GetMedicationsApi getMedicationsApi;

    private final GetServicesApi getServicesApi;

    private final GetPatientByFullNameApi getPatientByFullNameApi;

    public EmployeeController(GetEmployeeInfoByIdApi getEmployeeInfoByIdApi,
                              GetCurrentWeekWorkingScheduleApi getCurrentWeekWorkingScheduleApi,
                              GetMedicationsApi getMedicationsApi,
                              GetServicesApi getServicesApi,
                              GetPatientByFullNameApi getPatientByFullNameApi) {
        this.getEmployeeInfoByIdApi = getEmployeeInfoByIdApi;
        this.getCurrentWeekWorkingScheduleApi = getCurrentWeekWorkingScheduleApi;
        this.getMedicationsApi = getMedicationsApi;
        this.getServicesApi = getServicesApi;
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

    @GetMapping("/get-medication-list/{page}/{size}")
    public GetAllMedicationsResponse getMedicationList(@PathVariable int page, @PathVariable int size) {
        GetAllMedicationsRequest getAllMedicationsRequest = new GetAllMedicationsRequest(page, size);
        return getMedicationsApi.execute(getAllMedicationsRequest);
    }

    @GetMapping("/get-service-list/{page}/{size}")
    public GetAllServicesResponse getServiceList(@PathVariable int page, @PathVariable int size) {
        GetAllServicesRequest getAllServicesRequest = new GetAllServicesRequest(page, size);
        return getServicesApi.execute(getAllServicesRequest);
    }

    @GetMapping("/{employeeId}/search-by-name/{firstName}/{lastName}")
    public GetPatientsResponse searchPatientByName(@PathVariable Long employeeId,
                                                   @PathVariable String firstName,
                                                   @PathVariable String lastName) {
        GetPatientByFullNameRequest getPatientByFullNameRequest = new GetPatientByFullNameRequest(employeeId, firstName, lastName);
        return getPatientByFullNameApi.execute(getPatientByFullNameRequest);
    }
}
