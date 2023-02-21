package bg.softuni.resellerapp.controller;

import bg.softuni.resellerapp.model.binding.UserRegisterModel;
import bg.softuni.resellerapp.service.AuthService;
import bg.softuni.resellerapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final LoggedUser loggedUser;

    public RegisterController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }

    @GetMapping
    public String getRegister() {

        if (!this.loggedUser.isEmpty()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterModel")
                                       UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel",
                            bindingResult);

            return "redirect:register";
        }

        this.authService.registerUser(userRegisterModel);

        return "redirect:/login";
    }

    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel() {
        return new UserRegisterModel();
    }
}
