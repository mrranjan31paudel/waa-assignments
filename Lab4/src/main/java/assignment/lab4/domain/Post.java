package assignment.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;

    @ManyToOne
    private User author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeCommentById(long commentId){
        Comment commentToRemove = comments.stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst()
                .orElse(null);
        comments.remove(commentToRemove);
    }
}
