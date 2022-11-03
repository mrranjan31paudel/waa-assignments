package assignment.lab2.service;

import assignment.lab2.domain.dto.PostDto;
import assignment.lab2.domain.dto.UserDetailDto;
import assignment.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll(int postsMoreThan);

    public UserDto findById(long id);

    public void save(UserDto userDto);

    public UserDetailDto findUserPostsById(long id);

//    public void savePost(long userId, PostDto postDto);
//
//    public void deletePostById(long userId, long postId);
//
//    public void updatePostById(long userId, long postId, PostDto updatedPostDto);
}
