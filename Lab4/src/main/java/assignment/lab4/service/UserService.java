package assignment.lab4.service;

import assignment.lab4.domain.dto.PostDto;
import assignment.lab4.domain.dto.UserDetailDto;
import assignment.lab4.domain.dto.UserDto;
import assignment.lab4.domain.dto.UserPostCommentDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    public List<UserDto> findByPostMoreThan(int n);

    public List<UserDto> findUsersByPostTitle(String postTitle);

    public UserDto findById(long id);

    public UserDetailDto findUserPostsById(long id);

    public void save(UserDto userDto);

    public void deleteById(long id);

    public void savePost(long userId, PostDto postDto);

    public void deletePostById(long userId, long postId);

    public UserPostCommentDto findUserPostCommentById(long userId, long postId, long commentId);
}
