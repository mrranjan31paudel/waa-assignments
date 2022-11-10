package assignment.lab5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    @NotBlank
    String name;
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotEmpty
    List<String> roles;
}
