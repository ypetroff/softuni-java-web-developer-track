package bg.softuni.resellerapp.validation.passwordMatcher;

import bg.softuni.resellerapp.model.binding.UserRegisterModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterModel> {

    private final PasswordEncoder passwordEncoder;

    public PasswordMatcher(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterModel user, ConstraintValidatorContext context) {

        if(user.getPassword() != null &&
                user.getPassword().equals(user.getConfirmPassword())) {
            return true;
        }

        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode("confirmPassword")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
