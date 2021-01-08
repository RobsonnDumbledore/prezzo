package br.com.noblesse.prezzo.exceptions;

import br.com.noblesse.prezzo.errors.StandardError;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Robson
 */
@ControllerAdvice
public class StandardExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<StandardError> usernameNotFoundException(
            UsernameNotFoundException e,
            HttpServletRequest request) {

        StandardError standardError = new StandardError(
                UNAUTHORIZED.value(),
                "CREDENCIAIS INVÁLIDAS",
                request.getRequestURI());

        return ResponseEntity.status(UNAUTHORIZED).body(standardError);

    }

    @ExceptionHandler(InvalidPasswordException.class)
    protected ResponseEntity<StandardError> invalidPasswordException(
            InvalidPasswordException e,
            HttpServletRequest request) {
        StandardError standardError = new StandardError(
                UNAUTHORIZED.value(),
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(UNAUTHORIZED).body(standardError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<StandardError> handleEntityNotFound(
            EntityNotFoundException e,
            HttpServletRequest request) {

        StandardError standardError = new StandardError(
                NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    protected ResponseEntity<StandardError> duplicateKeyException(
            DuplicateKeyException e,
            HttpServletRequest request) {

        StandardError standardError = new StandardError(
                BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(BAD_REQUEST).body(standardError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        StandardError error = new StandardError(BAD_REQUEST.value(),
                "validation error", request.getDescription(false));

        error.addValidationErrors(ex.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(error, BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        String error = "Malformed JSON request";
        StandardError standardError = new StandardError(BAD_REQUEST.value(), error,
                request.getDescription(false));
        return new ResponseEntity<>(standardError, BAD_REQUEST);
    }

}
