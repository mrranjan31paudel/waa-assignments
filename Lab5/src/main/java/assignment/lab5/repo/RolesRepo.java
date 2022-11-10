package assignment.lab5.repo;

import assignment.lab5.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepo extends CrudRepository<Role, Integer> {
    List<Role> findByNameIn(List<String> names);
}
