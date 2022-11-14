package assignment.lab6.aspect;

import assignment.lab6.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    final private LogService logService;

    @Autowired
    public LoggerAspect(LogService logService) {
        this.logService = logService;
    }

    // match any method with any number of arguments in the controller package
    @Pointcut("execution(* assignment.lab6.controller.*.*(..))")
    public void logUserActivity() {
    }

    public void generateLog(String[] basePath, String[] path, JoinPoint joinPoint, String requestMethod) {
        String operationString = Util.getOperationString(basePath, path, joinPoint, requestMethod);

        logService.save(LocalDateTime.now(), 4L, operationString);
    }

    @After("logUserActivity() && @target(requestMapping) && (@annotation(getMapping))")
    public void logUserGetActivityAfter(JoinPoint joinPoint, RequestMapping requestMapping, GetMapping getMapping) {
        generateLog(requestMapping.value(), getMapping.value(), joinPoint, "GET");
    }

    @After("logUserActivity() && @target(requestMapping) && (@annotation(postMapping))")
    public void logUserPostActivityAfter(JoinPoint joinPoint, RequestMapping requestMapping, PostMapping postMapping) {
        generateLog(requestMapping.value(), postMapping.value(), joinPoint, "POST");
    }

    @After("logUserActivity() && @target(requestMapping) && (@annotation(putMapping))")
    public void logUserPutActivityAfter(JoinPoint joinPoint, RequestMapping requestMapping, PutMapping putMapping) {
        generateLog(requestMapping.value(), putMapping.value(), joinPoint, "PUT");
    }

    @After("logUserActivity() && @target(requestMapping) && (@annotation(deleteMapping))")
    public void logUserDeleteActivityAfter(JoinPoint joinPoint, RequestMapping requestMapping, DeleteMapping deleteMapping) {
        generateLog(requestMapping.value(), deleteMapping.value(), joinPoint, "DELETE");
    }
}
