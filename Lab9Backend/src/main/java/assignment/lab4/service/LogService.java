package assignment.lab4.service;

import assignment.lab4.domain.Logger;
import assignment.lab4.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public interface LogService {
    public void save(LocalDateTime dateTime, Long userId, String operation);
}
