package assignment.lab3.controller;

import assignment.lab3.domain.dto.PostDto;
import assignment.lab3.domain.dto.UserDetailDto;
import assignment.lab3.domain.dto.UserDto;
import assignment.lab3.service.UserService;
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
    public List<UserDto> getUsers(@RequestParam(name = "posts_more_than", required = false) Long postsMoreThan) {
        if(postsMoreThan == null)
            return userService.findAll();

        return  userService.findByPostMoreThan((long)postsMoreThan);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public UserDetailDto getUserPostsById(@PathVariable long id) {
        return userService.findUserPostsById(id);
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