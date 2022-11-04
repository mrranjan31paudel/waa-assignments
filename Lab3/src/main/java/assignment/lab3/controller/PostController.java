package assignment.lab3.controller;

import assignment.lab3.domain.Comment;
import assignment.lab3.domain.dto.CommentDto;
import assignment.lab3.domain.dto.PostDetailDto;
import assignment.lab3.domain.dto.PostDto;
import assignment.lab3.service.PostService;
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
    public List<PostDto> getPosts(@RequestParam(value = "title", required = false) String title) {
        if(title == null)
            return postService.findAll();

        return postService.findByTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id) {
        return postService.findById(id);
    }

    @GetMapping("/{id}/comments")
    public PostDetailDto getPostComments(@PathVariable("id") long postId){
        return postService.findPostWithCommentsById(postId);
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
