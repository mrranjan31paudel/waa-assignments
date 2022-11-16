package assignment.lab4.service.impl;

import assignment.lab4.domain.Logger;
import assignment.lab4.domain.User;
import assignment.lab4.domain.dto.UserDto;
import assignment.lab4.repo.LogRepo;
import assignment.lab4.repo.UserRepo;
import assignment.lab4.service.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    final private LogRepo logRepo;
    final private UserRepo userRepo;
    final private ModelMapper modelMapper;

    @Autowired
    public LogServiceImpl(LogRepo logRepo, UserRepo userRepo, ModelMapper modelMapper){
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void save(LocalDateTime dateTime, Long userId, String operation) {
        User user = userRepo.findById(userId).orElse(null);

        Logger log = new Logger();
        log.setDateTime(dateTime);

        if(user != null)
            log.setPrinciple(user);

        log.setOperation(operation);

        logRepo.save(log);
    }
}
