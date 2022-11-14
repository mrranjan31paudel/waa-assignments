package assignment.lab6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostCommentDto {
    private long id;
    private long postId;
    private long userId;
    private String name;
}
