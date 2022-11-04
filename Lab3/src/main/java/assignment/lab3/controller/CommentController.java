package assignment.lab3.controller;

import assignment.lab3.domain.dto.CommentDto;
import assignment.lab3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/comments")
@RestController
public class CommentController {
    final private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable long id){
        return commentService.findById(id);
    }
}
