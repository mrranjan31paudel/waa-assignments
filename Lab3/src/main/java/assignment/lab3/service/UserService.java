package assignment.lab3.service;

import assignment.lab3.domain.dto.PostDto;
import assignment.lab3.domain.dto.UserDetailDto;
import assignment.lab3.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    public List<UserDto> findByPostMoreThan(long n);

    public UserDto findById(long id);

    public UserDetailDto findUserPostsById(long id);

    public void save(UserDto userDto);

    public void deleteById(long id);

    public void savePost(long userId, PostDto postDto);

    public void deletePostById(long userId, long postId);
}
