package bg.softuni.resellerapp.controller;

import bg.softuni.resellerapp.model.binding.UserLoginModel;
import bg.softuni.resellerapp.service.AuthService;
import bg.softuni.resellerapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;
    private final LoggedUser loggedUser;

    @Autowired
    public LoginController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }

    @GetMapping
    public String getLogin() {

        if (!this.loggedUser.isEmpty()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping
    public String postLogin(@Valid @ModelAttribute(name = "userLoginModel") UserLoginModel userLoginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userLoginModel", bindingResult);

            return "redirect:login";
        }

        //TODO: check behaviour without this boolean
//        boolean validateCredentials = this.authService.checkCredentials(userLoginModel.getUsername(),
//                                                                        userLoginModel().getPassword());

        this.authService.loginUser(userLoginModel);
        return "redirect:/home";
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel() {
        return new UserLoginModel();
    }
}
