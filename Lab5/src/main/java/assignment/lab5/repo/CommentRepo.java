package assignment.lab5.repo;

import assignment.lab5.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    public List<Comment> findAll();
}
