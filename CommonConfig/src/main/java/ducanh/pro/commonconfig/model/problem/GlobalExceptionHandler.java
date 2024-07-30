package ducanh.pro.commonconfig.model.problem;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ProblemDetail handleNotFoundException(NotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getDetail());
        problemDetail.setTitle(e.getTitle());

        if (e.getParameters() != null) {
            for (Map.Entry<String, Object> entry : e.getParameters().entrySet()) {
                problemDetail.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return problemDetail;
    }

    @ExceptionHandler(BadRequestException.class)
    ProblemDetail handleBadRequestException(BadRequestException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getDetail());
        if (!(StringUtils.hasText(e.getTitle()) || StringUtils.hasText(e.getDetail())) && StringUtils.hasText(e.getMessage())) {
            problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        problemDetail.setTitle(e.getTitle());

        if (e.getParameters() != null) {
            for (Map.Entry<String, Object> entry : e.getParameters().entrySet()) {
                problemDetail.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return problemDetail;
    }

    @ExceptionHandler(InternalServerException.class)
    ProblemDetail handleInternalServerException(InternalServerException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getDetail());
        problemDetail.setTitle(e.getTitle());

        if (e.getParameters() != null) {
            for (Map.Entry<String, Object> entry : e.getParameters().entrySet()) {
                problemDetail.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return problemDetail;
    }

    @ExceptionHandler(UnauthorizedException.class)
    ProblemDetail handleUnauthorizedException(UnauthorizedException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, e.getDetail());
        problemDetail.setTitle(e.getTitle());

        if (e.getParameters() != null) {
            for (Map.Entry<String, Object> entry : e.getParameters().entrySet()) {
                problemDetail.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return problemDetail;
    }

    @ExceptionHandler(ForbiddenException.class)
    ProblemDetail handleForbiddenException(ForbiddenException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, e.getDetail());
        problemDetail.setTitle(e.getTitle());

        if (e.getParameters() != null) {
            for (Map.Entry<String, Object> entry : e.getParameters().entrySet()) {
                problemDetail.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return problemDetail;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ProblemDetail handleConstraintViolationException(ConstraintViolationException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        problemDetail.setTitle("Constraint Violation");

        List<Violation> violations = new ArrayList<>();
        ex.getConstraintViolations().forEach(fieldError ->
                violations.add(new Violation(fieldError.getPropertyPath().toString(), fieldError.getMessage())));

        Map<String, Object> errorParameters = new HashMap<>();
        errorParameters.put("violations", violations);
        problemDetail.setProperties(errorParameters);

        return problemDetail;
    }

}
