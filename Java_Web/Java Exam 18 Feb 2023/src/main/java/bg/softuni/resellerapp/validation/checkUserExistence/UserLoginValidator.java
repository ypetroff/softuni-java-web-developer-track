package bg.softuni.resellerapp.validation.checkUserExistence;

import bg.softuni.resellerapp.model.binding.UserLoginModel;
import bg.softuni.resellerapp.service.AuthService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final AuthService authService;

    public UserLoginValidator(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLogin, ConstraintValidatorContext context) {

       return this.authService.checkCredentials(userLogin.getUsername(),
                                                userLogin.getPassword());
    }
}
