package assignment.lab6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(length = 50, unique = true)
    String name;

    @Column(length = 50, unique = true)
    String username;
    String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    List<Role> roles;

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
