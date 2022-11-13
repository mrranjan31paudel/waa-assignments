package assignment.lab6.controller;

import assignment.lab6.domain.dto.CommentDto;
import assignment.lab6.domain.dto.PostDetailDto;
import assignment.lab6.domain.dto.PostDto;
import assignment.lab6.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public List<PostDto> getPosts(@RequestParam(value = "title", required = false) String title) {
        if(title == null)
            return postService.findAll();

        return postService.findByTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        PostDto postDto = postService.findById(id);

        if(postDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return postDto;
    }

    @GetMapping("/{id}/comments")
    public PostDetailDto getPostComments(@PathVariable("id") long postId){
        PostDetailDto postDetailDto = postService.findPostWithCommentsById(postId);

        if(postDetailDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return postDetailDto;
    }

    @PostMapping("/{id}/comments")
    public void addComment(@PathVariable("id") long postId, @RequestBody CommentDto commentDto){
        postService.saveCommentById(postId, commentDto);
    }

    @DeleteMapping("/{id}/comments/{comment_id}")
    public void deleteComment(@PathVariable("id") long postId, @PathVariable("comment_id") long commentId){
        postService.deleteCommentById(postId, commentId);
    }
}
