package assignment.lab4.controller;

import assignment.lab4.domain.dto.PostDto;
import assignment.lab4.domain.dto.UserDetailDto;
import assignment.lab4.domain.dto.UserDto;
import assignment.lab4.domain.dto.UserPostCommentDto;
import assignment.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public UserDetailDto getUserPostsById(@PathVariable long id) {
        return userService.findUserPostsById(id);
    }

    @GetMapping("/{id}/posts/{post_id}/comments/{comment_id}")
    public UserPostCommentDto getUserPostCommentById(@PathVariable("id") long userId, @PathVariable("post_id") long postId, @PathVariable("comment_id") long commentId){
        return userService.findUserPostCommentById(userId, postId, commentId);
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
    public void addPost(@PathVariable("id") long postId, @RequestBody PostDto postDto){
        userService.savePost(postId, postDto);
    }

    @DeleteMapping("/{id}/posts/{post_id}")
    public void deletePost(@PathVariable("id") long id, @PathVariable("post_id") long postId){
        userService.deletePostById(id, postId);
    }
}
