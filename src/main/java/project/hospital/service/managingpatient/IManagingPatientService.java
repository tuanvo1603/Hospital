package project.hospital.service.managingpatient;

import project.hospital.model.managingpatient.ManagingPatient;

public interface IManagingPatientService <T extends ManagingPatient>{

    T initManagingPatient(Long patientId);

    T getManagingPatientById(Long patientId);

    void updateManagingPatient(Long patientId, T t);
}
