package assignment.lab6.service;

import java.time.LocalDateTime;

public interface LogService {
    public void save(LocalDateTime dateTime, Long userId, String operation);
}
