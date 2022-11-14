package assignment.lab6.repo;

import assignment.lab6.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends CrudRepository<Logger, Long> {
}
