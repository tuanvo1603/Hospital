package project.hospital.controller.employee.doctor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.employee.*;
import project.hospital.api.managingpatient.AssignNurseForInpatientApi;
import project.hospital.api.managingpatient.AssignResidentDoctorForInpatientApi;
import project.hospital.api.patient.GetInpatientTreatAtDepartmentApi;
import project.hospital.api.treatment.medication.DeleteMedicationApi;
import project.hospital.api.treatment.medication.InsertMedicationApi;
import project.hospital.api.treatment.medication.UpdateMedicationApi;
import project.hospital.api.treatment.service.DeleteServiceApi;
import project.hospital.api.treatment.service.InsertServiceApi;
import project.hospital.api.treatment.service.UpdateServiceApi;
import project.hospital.api.workingschedule.DeleteWorkingScheduleApi;
import project.hospital.api.workingschedule.InsertWorkingScheduleApi;
import project.hospital.model.employee.Administrator;
import project.hospital.model.employee.Department;
import project.hospital.model.employee.Nurse;
import project.hospital.model.employee.Technician;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.schedule.WorkingSchedule;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.repository.employee.DepartmentRepository;
import project.hospital.request.employee.*;
import project.hospital.request.managingpatient.AssignNurseForInpatientRequest;
import project.hospital.request.managingpatient.AssignResidentDoctorForInpatientRequest;
import project.hospital.request.patient.GetInpatientsTreatAtDepartmentRequest;
import project.hospital.request.treatment.medication.DeleteMedicationRequest;
import project.hospital.request.treatment.medication.InsertMedicationRequest;
import project.hospital.request.treatment.medication.UpdateMedicationRequest;
import project.hospital.request.treatment.service.DeleteServiceRequest;
import project.hospital.request.treatment.service.InsertServiceRequest;
import project.hospital.request.treatment.service.UpdateServiceRequest;
import project.hospital.request.workingschedule.DeleteWorkingScheduleRequest;
import project.hospital.request.workingschedule.InsertWorkingScheduleRequest;
import project.hospital.response.employee.DeleteEmployeeResponse;
import project.hospital.response.employee.GetAllEmployeesInDepartmentResponse;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.response.managingpatient.AssignDoctorForPatientResponse;
import project.hospital.response.managingpatient.AssignNurseForInpatientResponse;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.medication.DeleteMedicationResponse;
import project.hospital.response.treatment.medication.InsertMedicationResponse;
import project.hospital.response.treatment.medication.UpdateMedicationResponse;
import project.hospital.response.treatment.service.DeleteServiceResponse;
import project.hospital.response.treatment.service.InsertServiceResponse;
import project.hospital.response.treatment.service.UpdateServiceResponse;
import project.hospital.response.workingschedule.DeleteWorkingScheduleResponse;
import project.hospital.response.workingschedule.InsertWorkingScheduleResponse;

@RestController
@RequestMapping("/v1/dean")
@PreAuthorize("hasRole('DEAN')")
public class DeanController {

    private final InsertResidentDoctorApi insertResidentDoctorApi;

    private final InsertSpecialistDoctorApi insertSpecialistDoctorApi;

    private final InsertNurseApi insertNurseApi;

    private final InsertTechnicianApi insertTechnicianApi;

    private final InsertAdministratorApi insertAdministratorApi;

    private final InsertMedicationApi insertMedicationApi;

    private final InsertServiceApi insertServiceApi;

    private final UpdateServiceApi updateServiceApi;

    private final UpdateMedicationApi updateMedicationApi;

    private final DeleteEmployeeApi deleteEmployeeApi;

    private final DeleteMedicationApi deleteMedicationApi;

    private final DeleteServiceApi deleteServiceApi;

    private final GetAllEmployeesInDepartmentApi getAllEmployeesInDepartmentApi;

    private final GetInpatientTreatAtDepartmentApi getInpatientsTreatAtDepartmentApi;

    private final InsertWorkingScheduleApi insertWorkingScheduleApi;

    private final DeleteWorkingScheduleApi deleteWorkingScheduleApi;

    private final AssignResidentDoctorForInpatientApi assignResidentDoctorForInpatientApi;

    private final AssignNurseForInpatientApi assignNurseForInpatientApi;

    private final DepartmentRepository departmentRepository;

    public DeanController(InsertResidentDoctorApi insertResidentDoctorApi,
                          InsertSpecialistDoctorApi insertSpecialistDoctorApi,
                          InsertNurseApi insertNurseApi,
                          InsertTechnicianApi insertTechnicianApi,
                          InsertAdministratorApi insertAdministratorApi,
                          InsertMedicationApi insertMedicationApi,
                          InsertServiceApi insertServiceApi,
                          UpdateServiceApi updateServiceApi,
                          UpdateMedicationApi updateMedicationApi,
                          DeleteEmployeeApi deleteEmployeeApi,
                          DeleteMedicationApi deleteMedicationApi,
                          DeleteServiceApi deleteServiceApi,
                          GetAllEmployeesInDepartmentApi getAllEmployeesInDepartmentApi,
                          GetInpatientTreatAtDepartmentApi getInpatientsTreatAtDepartmentApi,
                          InsertWorkingScheduleApi insertWorkingScheduleApi,
                          DeleteWorkingScheduleApi deleteWorkingScheduleApi,
                          AssignResidentDoctorForInpatientApi assignResidentDoctorForInpatientApi,
                          AssignNurseForInpatientApi assignNurseForInpatientApi,
                          DepartmentRepository departmentRepository) {
        this.insertResidentDoctorApi = insertResidentDoctorApi;
        this.insertSpecialistDoctorApi = insertSpecialistDoctorApi;
        this.insertNurseApi = insertNurseApi;
        this.insertTechnicianApi = insertTechnicianApi;
        this.insertAdministratorApi = insertAdministratorApi;
        this.insertMedicationApi = insertMedicationApi;
        this.insertServiceApi = insertServiceApi;
        this.updateServiceApi = updateServiceApi;
        this.updateMedicationApi = updateMedicationApi;
        this.deleteEmployeeApi = deleteEmployeeApi;
        this.deleteMedicationApi = deleteMedicationApi;
        this.deleteServiceApi = deleteServiceApi;
        this.getAllEmployeesInDepartmentApi = getAllEmployeesInDepartmentApi;
        this.getInpatientsTreatAtDepartmentApi = getInpatientsTreatAtDepartmentApi;
        this.insertWorkingScheduleApi = insertWorkingScheduleApi;
        this.deleteWorkingScheduleApi = deleteWorkingScheduleApi;
        this.assignResidentDoctorForInpatientApi = assignResidentDoctorForInpatientApi;
        this.assignNurseForInpatientApi = assignNurseForInpatientApi;
        this.departmentRepository = departmentRepository;
    }

    @DeleteMapping("/delete-employee/{employeeId}")
    public DeleteEmployeeResponse deleteEmployee(@PathVariable Long employeeId) {
        DeleteEmployeeRequest deleteEmployeeRequest = new DeleteEmployeeRequest(employeeId);
        return deleteEmployeeApi.execute(deleteEmployeeRequest);
    }

    @GetMapping("/get-patient-in-department/{department}")
    public GetPatientsResponse getAllPatientInDepartment(@PathVariable String department) {
        GetInpatientsTreatAtDepartmentRequest getInpatientsTreatAtDepartmentRequest = new GetInpatientsTreatAtDepartmentRequest(department);
        return getInpatientsTreatAtDepartmentApi.execute(getInpatientsTreatAtDepartmentRequest);
    }

    @GetMapping("/show-department-employees/{department}")
    public GetAllEmployeesInDepartmentResponse showDepartmentEmployees(@PathVariable String department) {
        GetAllEmployeesInDepartmentRequest getAllEmployeesInDepartmentRequest = new GetAllEmployeesInDepartmentRequest(department);
        return getAllEmployeesInDepartmentApi.execute(getAllEmployeesInDepartmentRequest);
    }

    @PostMapping("/insert-resident-doctor")
    public InsertEmployeeResponse insertResidentDoctor(@RequestBody ResidentDoctor residentDoctor) {
        InsertResidentDoctorRequest insertResidentDoctorRequest = new InsertResidentDoctorRequest(residentDoctor);
        return insertResidentDoctorApi.execute(insertResidentDoctorRequest);
    }

    @PostMapping("/insert-specialist-doctor")
    public InsertEmployeeResponse insertSpecialistDoctor(@RequestBody SpecialistDoctor specialistDoctor) {
        InsertSpecialistDoctorRequest insertSpecialistDoctorRequest = new InsertSpecialistDoctorRequest(specialistDoctor);
        return insertSpecialistDoctorApi.execute(insertSpecialistDoctorRequest);
    }

    @PostMapping("/insert-technician")
    public InsertEmployeeResponse insertTechnician(@RequestBody Technician technician) {
        InsertTechnicianRequest insertTechnicianRequest = new InsertTechnicianRequest(technician);
        return insertTechnicianApi.execute(insertTechnicianRequest);
    }

    @PostMapping("/insert-nurse")
    public InsertEmployeeResponse insertNurse(@RequestBody Nurse nurse) {
        InsertNurseRequest insertNurseRequest = new InsertNurseRequest(nurse);
        return insertNurseApi.execute(insertNurseRequest);
    }

    @PostMapping("/insert-administrator")
    public InsertEmployeeResponse insertAdministrator(@RequestBody Administrator administrator) {
        InsertAdministratorRequest insertAdministratorRequest = new InsertAdministratorRequest(administrator);
        return insertAdministratorApi.execute(insertAdministratorRequest);
    }

    @PutMapping("/insert-working-schedule")
    public InsertWorkingScheduleResponse insertWorkingSchedule(@RequestBody WorkingSchedule workingSchedule) {
        InsertWorkingScheduleRequest insertWorkingScheduleRequest = new InsertWorkingScheduleRequest(workingSchedule);
        return insertWorkingScheduleApi.execute(insertWorkingScheduleRequest);
    }

    @DeleteMapping("/delete-working-schedule/{employeeId}")
    public DeleteWorkingScheduleResponse deleteWorkingScheduleForEmployee(@PathVariable Long employeeId) {
        DeleteWorkingScheduleRequest deleteWorkingScheduleRequest = new DeleteWorkingScheduleRequest(employeeId);
        return deleteWorkingScheduleApi.execute(deleteWorkingScheduleRequest);
    }

    @PutMapping("/assign-doctor-for-inpatient/{doctorId}/{patientId}")
    public AssignDoctorForPatientResponse assignManagingDoctorForPatient(@PathVariable Long doctorId,
                                                                         @PathVariable Long patientId) {
        AssignResidentDoctorForInpatientRequest assignResidentDoctorForInpatientRequest = new AssignResidentDoctorForInpatientRequest(doctorId, patientId);
        return assignResidentDoctorForInpatientApi.execute(assignResidentDoctorForInpatientRequest);
    }

    @PutMapping("/set-nurse-for-patient/{nurseId}/{patientId}")
    public AssignNurseForInpatientResponse setManagingNurseForPatient(@PathVariable Long nurseId,
                                                                      @PathVariable Long patientId) {
        AssignNurseForInpatientRequest assignNurseForInpatientRequest = new AssignNurseForInpatientRequest(nurseId, patientId);
        return assignNurseForInpatientApi.execute(assignNurseForInpatientRequest);
    }

    @PostMapping("/import-medication")
    public InsertMedicationResponse importMedication(@RequestBody Medication medication) {
        InsertMedicationRequest insertMedicationRequest = new InsertMedicationRequest(medication);
        return insertMedicationApi.execute(insertMedicationRequest);
    }

    @PostMapping("/import-service")
    public InsertServiceResponse importService(@RequestBody HospitalServiceEntity hospitalServiceEntity) {
        InsertServiceRequest insertServiceRequest = new InsertServiceRequest(hospitalServiceEntity);
        return insertServiceApi.execute(insertServiceRequest);
    }

    @PutMapping("/update-medication/{medicationId}")
    public UpdateMedicationResponse updateMedication(@RequestBody Medication medication, @PathVariable Long medicationId) {
        UpdateMedicationRequest updateMedicationRequest = new UpdateMedicationRequest(medicationId, medication);
        return updateMedicationApi.execute(updateMedicationRequest);
    }

    @PutMapping("/update-service/{serviceId}")
    public UpdateServiceResponse updateService(@RequestBody HospitalServiceEntity hospitalServiceEntity, @PathVariable Long serviceId) {
        UpdateServiceRequest updateServiceRequest = new UpdateServiceRequest(serviceId, hospitalServiceEntity);
        return updateServiceApi.execute(updateServiceRequest);
    }

    @DeleteMapping("/delete-medication/{medicationId}")
    public DeleteMedicationResponse deleteMedication(@PathVariable Long medicationId) {
        DeleteMedicationRequest deleteMedicationRequest = new DeleteMedicationRequest(medicationId);
        return deleteMedicationApi.execute(deleteMedicationRequest);
    }

    @DeleteMapping("/delete-service/{serviceId}")
    public DeleteServiceResponse deleteService(@PathVariable Long serviceId) {
        DeleteServiceRequest deleteServiceRequest = new DeleteServiceRequest(serviceId);
        return deleteServiceApi.execute(deleteServiceRequest);
    }

    @PostMapping("/insert-department")
    public void insertDepartment(@RequestParam("department") String department,
                                 @RequestParam("officeLocation") String officeLocation) {
        Department department1 = new Department();
        department1.setDepartment(department);
        department1.setOfficeLocation(officeLocation);
        departmentRepository.save(department1);
    }

}
