package assignment.lab2.controller;

import assignment.lab2.domain.dto.PostDto;
import assignment.lab2.domain.dto.UserDetailDto;
import assignment.lab2.domain.dto.UserDto;
import assignment.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers(@RequestParam(name = "posts_more_than", required = false) int postsMoreThan) {
        return userService.findAll(postsMoreThan);
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

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/{id}/posts")
//    public void savePost(@PathVariable("id") long userId, @RequestBody PostDto postDto) {
//
//        userService.savePost(userId, postDto);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}/posts/{post_id}")
//    public void deletePostById(@PathVariable("id") long userId, @PathVariable("post_id") long postId) {
//        userService.deletePostById(userId, postId);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}/posts/{post_id}")
//    public void updateById(@PathVariable("id") long userId, @PathVariable("post_id") long postId, @RequestBody PostDto postDto) {
//        userService.updatePostById(userId, postId, postDto);
//    }
}
