package assignment.lab3.repo;

import assignment.lab3.domain.User;
import assignment.lab3.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE u.id IN(SELECT p.author FROM Post p GROUP BY p.author HAVING COUNT(p.author) > :n)")
    public List<User> findByPostsSizeGreaterThan(long n);
}
