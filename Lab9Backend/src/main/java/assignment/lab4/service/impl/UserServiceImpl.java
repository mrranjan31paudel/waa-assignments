package assignment.lab4.service.impl;

import assignment.lab4.domain.Comment;
import assignment.lab4.domain.Post;
import assignment.lab4.domain.User;
import assignment.lab4.domain.dto.*;
import assignment.lab4.repo.PostRepo;
import assignment.lab4.repo.UserRepo;
import assignment.lab4.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    final private UserRepo userRepo;
    final private PostRepo postRepo;
    final private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findByPostMoreThan(int n) {
        return userRepo.findByPostsSizeGreaterThan(n).stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersByPostTitle(String postTitle) {
        return userRepo.findDistinctByPostsTitleContainingIgnoreCase(postTitle).stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return userRepo.findById(id)
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElse(null);
    }

    @Override
    public UserDetailDto findUserPostsById(long id) {
        return userRepo.findById(id)
                .map(user -> modelMapper.map(user, UserDetailDto.class))
                .orElse(null);
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void savePost(long userId, PostCreationDto postDto) {
        User user = userRepo.findById(userId).orElse(null);

        if (user == null)
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Can't add post for a non-existing user!");

        Post post = modelMapper.map(postDto, Post.class);
        post.setAuthor(user);
        user.addPost(post);
        userRepo.save(user);
    }

    @Override
    public void deletePostById(long userId, long postId) {
        User user = userRepo.findById(userId).orElse(null);

        if (user == null)
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Can't delete post of a non-existing user!");

        user.removePostById(postId);
        userRepo.save(user);
        postRepo.deleteById(postId);
    }

    @Override
    public UserPostCommentDto findUserPostCommentById(long userId, long postId, long commentId) {
        UserPostCommentDto userPostCommentDto = new UserPostCommentDto(commentId, postId, userId, null);

        User user = userRepo.findAll().stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElse(null);

        if(user == null)
            return null;

        Post post = user.getPosts().stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .orElse(null);

        if(post == null)
            return null;

        Comment comment = post.getComments().stream()
                .filter(c -> c.getId() == commentId)
                .findFirst()
                .orElse(null);

        if(comment == null)
            return null;

        userPostCommentDto.setName(comment.getName());

        return userPostCommentDto;
    }
}
