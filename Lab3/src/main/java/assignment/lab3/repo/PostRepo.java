package assignment.lab3.repo;

import assignment.lab3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    public List<Post> findAll();

    public List<Post> findPostByTitleContainingIgnoreCase(String title);
}
