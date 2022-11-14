package assignment.lab6.service.impl;

import assignment.lab6.domain.Comment;
import assignment.lab6.domain.Post;
import assignment.lab6.domain.dto.CommentDto;
import assignment.lab6.domain.dto.PostDetailDto;
import assignment.lab6.domain.dto.PostDto;
import assignment.lab6.repo.CommentRepo;
import assignment.lab6.repo.PostRepo;
import assignment.lab6.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    final private PostRepo postRepo;
    final private CommentRepo commentRepo;
    final private ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, CommentRepo commentRepo){
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        return postRepo.findPostByTitleContainingIgnoreCase(title).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(long id) {
        return postRepo.findById(id)
                .map(post -> modelMapper.map(post, PostDto.class))
                .orElse(null);
    }

    @Override
    public PostDetailDto findPostWithCommentsById(long id) {
        return postRepo.findById(id)
                .map(post -> modelMapper.map(post, PostDetailDto.class))
                .orElse(null);
    }

    @Override
    public void saveCommentById(long postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElse(null);

        if(post == null)
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Can't add comment to a non-existing post!");

        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        post.addComment(comment);
        postRepo.save(post);
    }

    @Override
    public void deleteCommentById(long postId, long commentId) {
        Post post = postRepo.findById(postId).orElse(null);

        if(post == null)
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Can't delete comment of a non-existing post!");

        post.removeCommentById(commentId);
        postRepo.save(post);
        commentRepo.deleteById(commentId);
    }
}
