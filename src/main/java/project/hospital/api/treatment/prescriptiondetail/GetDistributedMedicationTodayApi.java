package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PrescriptionDetailDTO;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.request.treatment.prescription.GetDistributedMedicationTodayRequest;
import project.hospital.response.treatment.prescription.GetDistributedMedicationTodayResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.NurseService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

import java.util.List;

@Component
public class GetDistributedMedicationTodayApi extends Api<GetDistributedMedicationTodayRequest, GetDistributedMedicationTodayResponse> {

    private final NurseService nurseService;

    private final PrescriptionDetailService prescriptionDetailService;

    public GetDistributedMedicationTodayApi(NurseService nurseService,
                                            PrescriptionDetailService prescriptionDetailService,
                                            SessionService sessionService) {
        super(sessionService);
        this.nurseService = nurseService;
        this.prescriptionDetailService = prescriptionDetailService;
    }

    @Override
    public GetDistributedMedicationTodayResponse execute(GetDistributedMedicationTodayRequest requestData) {
        try{
            nurseService.checkExistenceOfEmployee(requestData.getEmployeeId());
            List<PrescriptionDetailDTO> prescriptionDetailDTOList = prescriptionDetailService.getAllPrescriptionTodayByPatientId(requestData.getPatientId());

            return new GetDistributedMedicationTodayResponse(prescriptionDetailDTOList);
        }catch (EmployeeNotFoundException e) {
            return new GetDistributedMedicationTodayResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new GetDistributedMedicationTodayResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
