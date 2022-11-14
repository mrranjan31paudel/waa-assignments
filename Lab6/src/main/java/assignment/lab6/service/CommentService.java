package assignment.lab6.service;

import assignment.lab6.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    public CommentDto findById(long id);
}
