package assignment.lab4.repo;

import assignment.lab4.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    public List<Post> findAll();

    public List<Post> findPostByTitleContainingIgnoreCase(String title);
}
