package project.hospital.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.hospital.exception.MedicationQuantityNotEnoughException;

@RestControllerAdvice
public class NotEnoughEquipment {

    @ExceptionHandler(MedicationQuantityNotEnoughException.class)
    public ResponseEntity<String> handleNotEnoughMedicationQuantity(MedicationQuantityNotEnoughException exception) {
        return new ResponseEntity<>("There are not enough these quantity of these types of medication in Medication Warehouse.", HttpStatus.NOT_ACCEPTABLE);
    }
}
