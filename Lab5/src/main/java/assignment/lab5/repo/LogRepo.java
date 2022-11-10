package assignment.lab5.repo;

import assignment.lab5.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends CrudRepository<Logger, Long> {
}
