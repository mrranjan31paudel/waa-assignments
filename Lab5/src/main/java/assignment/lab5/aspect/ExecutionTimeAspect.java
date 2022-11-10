package assignment.lab5.aspect;

import assignment.lab5.aspect.annotation.ExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(assignment.lab5.aspect.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println("Execution of the method "+proceedingJoinPoint.getSignature().getName() + " took " + (finish - start) + " ns");

        return result;
    }
}
