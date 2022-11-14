package assignment.lab5.service;

import assignment.lab5.domain.Logger;
import assignment.lab5.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public interface LogService {
    public void save(LocalDateTime dateTime, Long userId, String operation);
}
