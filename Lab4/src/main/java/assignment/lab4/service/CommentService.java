package assignment.lab4.service;

import assignment.lab4.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    public CommentDto findById(long id);
}
