package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;
import project.hospital.request.patient.AdmitOutpatientRequest;
import project.hospital.response.patient.AdmitOutpatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.managingpatient.AppointmentService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class AdmitOutpatientApi extends Api<AdmitOutpatientRequest, AdmitOutpatientResponse> {

    private final AdministratorService administratorService;

    private final OutpatientService outpatientService;

    private final TreatmentService treatmentService;

    private final HospitalFeeService hospitalFeeService;

    private final AppointmentService appointmentService;

    public AdmitOutpatientApi(AdministratorService administratorService,
                              OutpatientService outpatientService,
                              TreatmentService treatmentService,
                              HospitalFeeService hospitalFeeService,
                              AppointmentService appointmentService,
                              SessionService sessionService) {
        super(sessionService);
        this.administratorService = administratorService;
        this.outpatientService = outpatientService;
        this.treatmentService = treatmentService;
        this.hospitalFeeService = hospitalFeeService;
        this.appointmentService = appointmentService;
    }

    @Override
    public AdmitOutpatientResponse execute(AdmitOutpatientRequest requestData) {
        try{
            administratorService.checkExistenceOfEmployee(requestData.getAdministratorId());
            requestData.getOutpatient().setEmployeeId(requestData.getAdministratorId());
            Outpatient admitOutpatient = outpatientService.admitPatient(requestData.getOutpatient());
            Treatment treatment = treatmentService.createTreatment(admitOutpatient);
            appointmentService.initManagingPatient(admitOutpatient.getPatientId());
            hospitalFeeService.createHospitalFee(treatment);

            return new AdmitOutpatientResponse();
        }catch (EmployeeNotFoundException e) {
            return new AdmitOutpatientResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new AdmitOutpatientResponse(StatusCode.REQUEST.getCode(), e.getMessage());
        }
    }
}
