package assignment.lab3.repo;

import assignment.lab3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    public List<User> findAll();

    @Query("FROM User u WHERE u.posts.size > :n")
    public List<User> findByPostsSizeGreaterThan(int n);

    public List<User> findDistinctByPostsTitleContainingIgnoreCase(String title);
}
