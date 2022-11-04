package assignment.lab3.repo;

import assignment.lab3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    public List<Post> findPostByTitleContainingIgnoreCase(String title);
}
