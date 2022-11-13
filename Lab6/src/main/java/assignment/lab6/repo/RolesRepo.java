package assignment.lab6.repo;

import assignment.lab6.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepo extends CrudRepository<Role, Integer> {
    List<Role> findByNameIn(List<String> names);
}
