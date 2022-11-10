package assignment.lab5.service;

import assignment.lab5.domain.dto.CommentDto;
import assignment.lab5.domain.dto.PostDetailDto;
import assignment.lab5.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public List<PostDto> findByTitle(String title);

    public PostDto findById(long id);

    public PostDetailDto findPostWithCommentsById(long id);

    public void saveCommentById(long postId, CommentDto commentDto);

    public void deleteCommentById(long postId, long commentId);
}
