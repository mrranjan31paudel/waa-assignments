package assignment.lab4.controller;

import assignment.lab4.aspect.annotation.ExecutionTime;
import assignment.lab4.domain.dto.*;
import assignment.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    final private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers(@RequestParam(name = "posts_more_than", required = false) Integer postsMoreThan, @RequestParam(name = "post_title", required = false) String postTitle) {
        if(postsMoreThan == null && postTitle == null)
            return userService.findAll();

        if(postsMoreThan == null)
            return userService.findUsersByPostTitle(postTitle);

        return userService.findByPostMoreThan(postsMoreThan);
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        UserDto userDto = userService.findById(id);

        if(userDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userDto;
    }

    @GetMapping("/{id}/posts")
    public UserDetailDto getUserPostsById(@PathVariable long id) {
        UserDetailDto userDetailDto = userService.findUserPostsById(id);

        if(userDetailDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userDetailDto;
    }

    @GetMapping("/{id}/posts/{post_id}/comments/{comment_id}")
    public UserPostCommentDto getUserPostCommentById(@PathVariable("id") long userId, @PathVariable("post_id") long postId, @PathVariable("comment_id") long commentId){
        UserPostCommentDto userPostCommentDto = userService.findUserPostCommentById(userId, postId, commentId);

        if(userPostCommentDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return userPostCommentDto;
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }

    @PostMapping("/{id}/posts")
    public void addPost(@PathVariable("id") long postId, @RequestBody PostCreationDto postDto){
        userService.savePost(postId, postDto);
    }

    @DeleteMapping("/{id}/posts/{post_id}")
    public void deletePost(@PathVariable("id") long id, @PathVariable("post_id") long postId){
        userService.deletePostById(id, postId);
    }
}
