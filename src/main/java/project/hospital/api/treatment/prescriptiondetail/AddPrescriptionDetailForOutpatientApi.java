package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.*;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.request.treatment.prescription.InsertPrescriptionRequest;
import project.hospital.response.treatment.prescription.InsertPrescriptionResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

@Component
public class AddPrescriptionDetailForOutpatientApi extends Api<InsertPrescriptionRequest, InsertPrescriptionResponse> {

    private final SpecialistDoctorService specialistDoctorService;

    private final OutpatientService outpatientService;

    private final PrescriptionDetailService prescriptionDetailService;

    public AddPrescriptionDetailForOutpatientApi(SpecialistDoctorService specialistDoctorService,
                                                 OutpatientService outpatientService,
                                                 PrescriptionDetailService prescriptionDetailService,
                                                 SessionService sessionService) {
        super(sessionService);
        this.specialistDoctorService = specialistDoctorService;
        this.outpatientService = outpatientService;
        this.prescriptionDetailService = prescriptionDetailService;
    }

    @Override
    public InsertPrescriptionResponse execute(InsertPrescriptionRequest requestData) {
        try {
            specialistDoctorService.checkExistenceOfEmployee(requestData.getDoctorId());
            outpatientService.checkExistenceOfPatient(requestData.getPatientId());
            prescriptionDetailService.createPrescriptionDetail(requestData.getPatientId(), requestData.getPrescriptionDetail());

            return new InsertPrescriptionResponse();
        }catch (PatientNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Patient may be not managed in system.");
        }catch (EmployeeNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (TreatmentNotFoundException e){
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "There is no treatment of the patient in system.");
        }catch (MedicationNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Error in medicationId.");
        }catch (MedicationQuantityNotEnoughException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "There is not enough medication quantity in medication warehouse.");
        }catch (Exception e) {
            return new InsertPrescriptionResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
