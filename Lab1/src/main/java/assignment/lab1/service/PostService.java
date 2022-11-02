package assignment.lab1.service;

import assignment.lab1.domain.Post;
import assignment.lab1.domain.dto.PostDto;
import assignment.lab1.domain.dto.PostFilterDto;
import assignment.lab1.repo.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public List<PostDto> findByFilters(PostFilterDto postFilterDto);

    public PostDto findById(long id);

    public void save(PostDto postDto);

    public void deleteById(long id);

    public void updateById(long id, PostDto updatedPostDto);
}
