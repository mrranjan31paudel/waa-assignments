package assignment.lab6.service;

import assignment.lab6.domain.dto.*;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    List<UserDto> findByPostMoreThan(int n);

    List<UserDto> findUsersByPostTitle(String postTitle);

    UserDto findById(long id);

    UserDetailDto findUserPostsById(long id);

    void save(UserCreationDto userCreationDto);

    void deleteById(long id);

    void savePost(long userId, PostDto postDto);

    void deletePostById(long userId, long postId);

    UserPostCommentDto findUserPostCommentById(long userId, long postId, long commentId);
}
