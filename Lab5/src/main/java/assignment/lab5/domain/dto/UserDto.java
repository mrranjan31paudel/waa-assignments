package assignment.lab5.domain.dto;

import assignment.lab5.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    long id;
    String name;
    List<Role> roles;
}
