package be.technifutur.benjamiche.form;

import be.technifutur.benjamiche.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class RegistrationForm {

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$")
    private String username;
    @NotNull
    @Size(min=4)
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoles(Set.of("ROLE_USER"));
        return user;
    }
}
