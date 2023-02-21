package bg.softuni.resellerapp.model.binding;

import bg.softuni.resellerapp.validation.passwordMatcher.PasswordMatch;
import bg.softuni.resellerapp.validation.uniqueEmail.UniqueEmail;
import bg.softuni.resellerapp.validation.uniqueUsername.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @NotBlank
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;

    @NotEmpty(message = "Email cannot be empty!")
    @Email
    @UniqueEmail
    private String email;
}
