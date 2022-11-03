package assignment.lab2.controller;

import assignment.lab2.domain.dto.PostDto;
import assignment.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/posts")
@RestController
public class PostController {
    final private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        postService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateById(@PathVariable long id, @RequestBody PostDto postDto) {
        postService.updateById(id, postDto);
    }
}
