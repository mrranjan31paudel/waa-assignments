package assignment.lab6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailDto {
    private long id;
    private String title;
    private String content;
    List<CommentDto> comments;
}
