package assignment.lab4.service;

import assignment.lab4.domain.dto.CommentDto;
import assignment.lab4.domain.dto.PostDetailDto;
import assignment.lab4.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public List<PostDto> findByTitle(String title);

    public PostDto findById(long id);

    public PostDetailDto findPostWithCommentsById(long id);

    public void saveCommentById(long postId, CommentDto commentDto);

    public void deleteCommentById(long postId, long commentId);

    void deleteById(long postId);
}
