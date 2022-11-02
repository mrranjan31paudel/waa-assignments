package assignment.lab1.service.impl;

import assignment.lab1.domain.Post;
import assignment.lab1.domain.dto.PostDto;
import assignment.lab1.domain.dto.PostFilterDto;
import assignment.lab1.repo.PostRepo;
import assignment.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepo postRepo;
    private ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepo.findAll();

        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByFilters(PostFilterDto postFilterDto) {
        List<Post> posts = postRepo.findByFilters(postFilterDto);

        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
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
        postRepo.updateById(id, modelMapper.map(updatedPostDto, Post.class));
    }
}
