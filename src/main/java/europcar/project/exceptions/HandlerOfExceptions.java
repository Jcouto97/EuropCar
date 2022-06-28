package europcar.project.exceptions;

import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.RESOURCE_ALREADY_EXISTS;

@ControllerAdvice
public class HandlerOfExceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {RentalNotFoundException.class, VehicleNotFoundException.class,
            UserNotFoundException.class, UserAlreadyExists.class, RentingException.class,
            AtributeNotFoundException.class, AtributeAttachedException.class, AgencyNotFoundException.class})
    protected ResponseEntity<Object> notFoundHandler(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, RESOURCE_ALREADY_EXISTS, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
