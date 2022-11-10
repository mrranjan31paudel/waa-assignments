package assignment.lab5.repo;

import assignment.lab5.domain.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepo extends CrudRepository<Exception, Long> {
}
