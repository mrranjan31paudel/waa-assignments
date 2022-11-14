package assignment.lab6.aspect;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class Util {
    public static String getOperationString(String[] basePath, String[] path, JoinPoint joinPoint, String requestMethod) {
        String requestPath = requestMethod + " " +
                ((basePath == null || basePath.length == 0) ? "" : basePath[0]) +
                ((path == null || path.length == 0) ? "" : path[0]);
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsString = args == null ? "[]" : Arrays.toString(args);
        String operationString = String.format("%s : %s(%s)", requestPath, methodName, argsString.substring(1, argsString.length() - 1));

        return operationString;
    }
}
