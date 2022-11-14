package assignment.lab6.service.impl;

import assignment.lab6.domain.dto.CommentDto;
import assignment.lab6.repo.CommentRepo;
import assignment.lab6.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    final private CommentRepo commentRepo;
    final private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo, ModelMapper modelMapper){
        this.commentRepo = commentRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CommentDto> findAll() {
        return commentRepo.findAll().stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(long id) {
        return commentRepo.findById(id)
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .orElse(null);
    }
}
