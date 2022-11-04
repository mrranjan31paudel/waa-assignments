package assignment.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    List<Post> posts;

    public void addPost(Post post){
        posts.add(post);
    }

    public void removePostById(long postId){
        Post postToRemove = posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElse(null);
        posts.remove(postToRemove);
    }
}
