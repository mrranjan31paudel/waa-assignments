package assignment.lab4.service;

import java.time.LocalDateTime;

public interface ExceptionService {
    public void save(LocalDateTime dateTime, long userId, String operation, String exceptionType);
}
