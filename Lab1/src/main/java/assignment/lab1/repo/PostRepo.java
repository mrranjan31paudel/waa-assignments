package assignment.lab1.repo;

import assignment.lab1.domain.Post;
import assignment.lab1.domain.dto.PostFilterDto;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    public List<Post> findByFilters(PostFilterDto postFilterDto);

    public Post findById(long id);

    public void save(Post post);

    public void deleteById(long id);

    public void updateById(long id, Post updatedPost);
}
