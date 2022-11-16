package assignment.lab4.repo;

import assignment.lab4.domain.User;
import assignment.lab4.domain.dto.UserPostCommentDto;
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

    @Query("SELECT u.id AS userId, p.id AS postId, c.id AS commentId, c.name AS name FROM User u LEFT JOIN Post p ON u.id=p.author.id LEFT JOIN Comment c ON p.id=c.post.id WHERE u.id = :userId AND p.id = :postId AND c.id = :commentId")
    public UserPostCommentDto findUserPostCommentById(long userId, long postId, long commentId);
}
