package assignment.lab1.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostFilterDto {
    private String title;
    private String author;

    public boolean isEmpty(){
        return isTitleEmpty() && isAuthorEmpty();
    }

    public boolean isTitleEmpty() {
        return (title == null || title.isBlank());
    }

    public boolean isAuthorEmpty() {
        return (author == null || author.isBlank());
    }
}
