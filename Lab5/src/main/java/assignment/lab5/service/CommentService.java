package assignment.lab5.service;

import assignment.lab5.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    public CommentDto findById(long id);
}
