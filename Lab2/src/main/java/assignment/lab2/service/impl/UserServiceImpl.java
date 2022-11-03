package assignment.lab2.service.impl;

import assignment.lab2.domain.Post;
import assignment.lab2.domain.User;
import assignment.lab2.domain.dto.PostDto;
import assignment.lab2.domain.dto.UserDetailDto;
import assignment.lab2.domain.dto.UserDto;
import assignment.lab2.repo.PostRepo;
import assignment.lab2.repo.UserRepo;
import assignment.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserRepo userRepo;
//    final PostRepo postRepo;
    final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
//        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAll(int postsMoreThan) {
        List<UserDto> users = new ArrayList<>();

        userRepo.findAll().forEach(user -> {
            if(user.getPosts().size() > postsMoreThan)
                users.add(modelMapper.map(user, UserDto.class));
        });

        return users;
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public UserDetailDto findUserPostsById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDetailDto.class);
    }

//    @Override
//    public void savePost(long userId, PostDto postDto) {
//        User user = userRepo.findById(userId).orElse(null);
//
//        if(user == null)
//            return; // should throw a user not found exception
//
//        Post post = postRepo.save(modelMapper.map(postDto, Post.class));
//        user.getPosts().add(post);
//        userRepo.save(user);
//    }
//
//    @Override
//    public void deletePostById(long userId, long postId) {
//        User user = userRepo.findById(userId).orElse(null);
//
//        if(user == null)
//            return; // should throw a user not found exception
//
//        Post postToDelete = user.getPosts().stream()
//                .filter(post -> post.getId() == postId)
//                .findFirst()
//                .orElse(null);
//        user.getPosts().remove(postToDelete);
//        userRepo.save(user);
//        postRepo.deleteById(postId);
//    }
//
//    @Override
//    public void updatePostById(long userId, long postId, PostDto updatedPostDto) {
//        User user = userRepo.findById(userId).orElse(null);
//
//        if(user == null)
//            return; // should throw a user not found exception
//
//        Post postToUpdate = user.getPosts().stream()
//                .filter(post -> post.getId() == postId)
//                .findFirst()
//                .orElse(null);
//
//        if(postToUpdate == null)
//            return;
//
//        postToUpdate.setTitle(updatedPostDto.getTitle());
//        postToUpdate.setContent(updatedPostDto.getContent());
//
//        userRepo.save(user);
//    }
}
