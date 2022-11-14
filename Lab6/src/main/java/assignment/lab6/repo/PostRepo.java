package assignment.lab6.repo;

import assignment.lab6.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    public List<Post> findAll();

    public List<Post> findPostByTitleContainingIgnoreCase(String title);
}
