package assignment.lab6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "Username cannot be null or blank!")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters long!")
    String username;

    @NotBlank(message = "Password cannot be null or blank!")
    @Size(min = 8, max = 20, message = "Password must be at least 8 and at most 20 characters long!")
    String password;
}
