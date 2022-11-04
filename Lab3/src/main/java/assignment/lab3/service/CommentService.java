package assignment.lab3.service;

import assignment.lab3.domain.Comment;
import assignment.lab3.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    public CommentDto findById(long id);
}
