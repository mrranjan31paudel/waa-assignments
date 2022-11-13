package assignment.lab6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    @NotBlank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters long!")
    String name;

    @NotBlank
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters long!")
    String username;

    @NotBlank @Size(min = 8, max = 20, message = "Password must be at least 8 and at most 20 characters long!") String password;

    @NotEmpty(message = "At least one role is required!")
    List<@Pattern(regexp = "(ADMIN|USER)", message = "Allowed roles: ADMIN, USER") String> roles;
}
