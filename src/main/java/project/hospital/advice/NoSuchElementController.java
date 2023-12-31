package project.hospital.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.hospital.exception.*;

@RestControllerAdvice
public class NoSuchElementController {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handleNoPatientInDB(PatientNotFoundException exception) {
        return new ResponseEntity<>("This patient is not managed in hospital.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectManagedEmployeeException.class)
    public ResponseEntity<String> handleIncorrectEmployeeId(IncorrectManagedEmployeeException exception) {
        return new ResponseEntity<>("This patient may be managed by other Employee.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicationNotFoundException.class)
    public ResponseEntity<String> handleIncorrectMedicationId(MedicationNotFoundException exception) {
        return new ResponseEntity<>("This medication is not existed in Medication Warehouse.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleNotExistingEmployee(EmployeeNotFoundException exception) {
        return new ResponseEntity<>("Error in authentication employee.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<String> handleNotExistingService(ServiceNotFoundException exception) {
        return new ResponseEntity<>("This service is not existed in Service Warehouse", HttpStatus.NOT_FOUND);
    }
}
