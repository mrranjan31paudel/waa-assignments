package assignment.lab1.repo.impl;

import assignment.lab1.domain.Post;
import assignment.lab1.domain.dto.PostFilterDto;
import assignment.lab1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private List<Post> posts;
    private static int postIdCounter = 100;

    public PostRepoImpl() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<Post> findByFilters(PostFilterDto postFilterDto) {
        return posts.stream()
                .filter(post -> (postFilterDto.isTitleEmpty() || post.getTitle().toLowerCase().contains(postFilterDto.getTitle().toLowerCase())))
                .filter(post -> (postFilterDto.isAuthorEmpty() || post.getAuthor().toLowerCase().contains(postFilterDto.getAuthor().toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(++postIdCounter);
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        Post postToRemove = posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
        posts.remove(postToRemove);
    }

    @Override
    public void updateById(long id, Post updatedPost) {
        Post postToUpdate = posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);

        postToUpdate.setAuthor(updatedPost.getAuthor());
        postToUpdate.setContent(updatedPost.getContent());
        postToUpdate.setTitle(updatedPost.getTitle());
    }
}
