package bg.softuni.resellerapp.controller;

import bg.softuni.resellerapp.service.AuthService;
import bg.softuni.resellerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    private final AuthService authService;
    private final LoggedUser loggedUser;

    @Autowired
    public LogoutController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }

    @GetMapping
    public String getLogout() {

        if (this.loggedUser.isEmpty()) {
            return "redirect:/";
        }

        this.authService.logoutUser();
        return "redirect:/";
    }
}
