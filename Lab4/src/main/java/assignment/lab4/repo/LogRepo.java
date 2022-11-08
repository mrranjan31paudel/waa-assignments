package assignment.lab4.repo;

import assignment.lab4.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends CrudRepository<Logger, Long> {
}
