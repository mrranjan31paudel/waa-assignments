package assignment.lab2.service.impl;

import assignment.lab2.domain.Post;
import assignment.lab2.domain.dto.PostDto;
import assignment.lab2.repo.PostRepo;
import assignment.lab2.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> findAll() {
        List<PostDto> posts = new ArrayList<>();

        postRepo.findAll()
                .forEach(post -> posts.add(modelMapper.map(post, PostDto.class)));

        return posts;
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(long id, PostDto updatedPostDto) {
        Post updatedPost = modelMapper.map(updatedPostDto, Post.class);
        updatedPost.setId(id);
        postRepo.save(updatedPost);
    }
}
