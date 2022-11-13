package assignment.lab6.aspect;

import assignment.lab6.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExceptionAspect {

    final private ExceptionService exceptionService;

    @Autowired
    public ExceptionAspect(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @Pointcut("execution(* assignment..*(..))")
    public void anyMethod(){
    }

    @AfterThrowing(pointcut = "anyMethod() && @target(requestMapping) && @annotation(getMapping)", throwing = "exception")
    public void logException(JoinPoint joinPoint, RequestMapping requestMapping, GetMapping getMapping, Exception exception) {
        generateExceptionLog(requestMapping.value(), getMapping.value(), joinPoint, "GET", exception);
    }

    @AfterThrowing(pointcut = "anyMethod() && @target(requestMapping) && @annotation(postMapping)", throwing = "exception")
    public void logException(JoinPoint joinPoint, RequestMapping requestMapping, PostMapping postMapping, Exception exception) {
        generateExceptionLog(requestMapping.value(), postMapping.value(), joinPoint, "POST", exception);
    }

    @AfterThrowing(pointcut = "anyMethod() && @target(requestMapping) && @annotation(putMapping)", throwing = "exception")
    public void logException(JoinPoint joinPoint, RequestMapping requestMapping, PutMapping putMapping, Exception exception) {
        generateExceptionLog(requestMapping.value(), putMapping.value(), joinPoint, "PUT", exception);
    }

    @AfterThrowing(pointcut = "anyMethod() && @target(requestMapping) && @annotation(deleteMapping)", throwing = "exception")
    public void logException(JoinPoint joinPoint, RequestMapping requestMapping, DeleteMapping deleteMapping, Exception exception) {
        generateExceptionLog(requestMapping.value(), deleteMapping.value(), joinPoint, "DELETE", exception);
    }

    public void generateExceptionLog(String[] basePath, String[] path, JoinPoint joinPoint, String requestMethod, Exception exception) {
        String operationString = Util.getOperationString(basePath, path, joinPoint, requestMethod);
        String exceptionTypeString = exception.getClass().getSimpleName() + ": " + exception.getMessage();

        try {
            exceptionService.save(LocalDateTime.now(), 4L, operationString, exceptionTypeString);
        }
        catch (Exception e){
            System.out.println("Failed to log the exception.\nOperation: " + operationString + "\nException: " + exceptionTypeString);
        }
    }
}
