package assignment.lab4.repo;

import assignment.lab4.domain.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<Exception, Long> {
}
