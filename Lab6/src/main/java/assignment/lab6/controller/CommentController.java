package assignment.lab6.controller;

import assignment.lab6.domain.dto.CommentDto;
import assignment.lab6.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        CommentDto commentDto = commentService.findById(id);

        if(commentDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return commentDto;
    }
}
