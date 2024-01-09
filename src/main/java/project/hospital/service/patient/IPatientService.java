package project.hospital.service.patient;

import project.hospital.model.patient.Patient;

public interface IPatientService <T extends Patient>{

    T getPatientById(Long patientId);

    void checkExistenceOfPatient(Long patientId);

    T admitPatient(T t);
}
