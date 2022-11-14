package assignment.lab5.service.impl;

import assignment.lab5.domain.Exception;
import assignment.lab5.domain.User;
import assignment.lab5.repo.ExceptionRepo;
import assignment.lab5.repo.UserRepo;
import assignment.lab5.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    final private UserRepo userRepo;
    final private ExceptionRepo exceptionRepo;

    @Autowired
    public ExceptionServiceImpl(UserRepo userRepo, ExceptionRepo exceptionRepo) {
        this.userRepo = userRepo;
        this.exceptionRepo = exceptionRepo;
    }


    @Override
    public void save(LocalDateTime dateTime, long userId, String operation, String exceptionType) {
        User user = userRepo.findById(userId).orElse(null);

        Exception exception = new Exception();
        exception.setDateTime(dateTime);

        if(user != null)
            exception.setPrinciple(user);

        exception.setOperation(operation);
        exception.setExceptionType(exceptionType);

        exceptionRepo.save(exception);
    }
}
