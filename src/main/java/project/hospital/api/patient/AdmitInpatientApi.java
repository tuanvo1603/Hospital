package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;
import project.hospital.request.patient.AdmitInpatientRequest;
import project.hospital.response.patient.AdmitInpatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class AdmitInpatientApi extends Api<AdmitInpatientRequest, AdmitInpatientResponse> {

    private final SpecialistDoctorService specialistDoctorService;

    private final InpatientService inpatientService;

    private final OutpatientService outpatientService;

    private final ManagingInpatientService managingInpatientService;

    private final TreatmentService treatmentService;

    public AdmitInpatientApi(SpecialistDoctorService specialistDoctorService,
                             InpatientService inpatientService,
                             OutpatientService outpatientService,
                             ManagingInpatientService managingInpatientService,
                             SessionService sessionService,
                             TreatmentService treatmentService) {
        super(sessionService);
        this.specialistDoctorService = specialistDoctorService;
        this.inpatientService = inpatientService;
        this.outpatientService = outpatientService;
        this.managingInpatientService = managingInpatientService;
        this.treatmentService = treatmentService;
    }

    @Override
    public AdmitInpatientResponse execute(AdmitInpatientRequest requestData) {
        try{
            SpecialistDoctor specialistDoctor = specialistDoctorService.getEmployeeById(requestData.getSpecialistDoctorId());
            Outpatient outpatient = outpatientService.getPatientById(requestData.getPatientId());
            Treatment treatment = treatmentService.getTreatmentById(requestData.getPatientId());
            Inpatient inpatient = inpatientService.admitInpatient(outpatient, treatment);
            inpatient.setDepartment(specialistDoctor.getDepartment());
            managingInpatientService.initManagingPatient(inpatient.getPatientId());
            outpatientService.dischargePatient(requestData.getPatientId());

            return new AdmitInpatientResponse();
        }catch (EmployeeNotFoundException e) {
            return new AdmitInpatientResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (PatientNotFoundException e) {
            return new AdmitInpatientResponse(StatusCode.REQUEST.getCode(), "Patient may not be managed in system.");
        }catch (Exception e) {
            return new AdmitInpatientResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
