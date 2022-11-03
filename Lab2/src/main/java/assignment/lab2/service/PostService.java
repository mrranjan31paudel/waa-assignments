package assignment.lab2.service;

import assignment.lab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto findById(long id);

    public void save(PostDto postDto);

    public void deleteById(long id);

    public void updateById(long id, PostDto updatedPostDto);
}
