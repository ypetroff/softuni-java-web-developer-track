package bg.softuni.resellerapp.controller;

import bg.softuni.resellerapp.model.OfferModel;
import bg.softuni.resellerapp.model.OfferRenderModel;
import bg.softuni.resellerapp.service.OfferService;
import bg.softuni.resellerapp.service.UserService;
import bg.softuni.resellerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final OfferService offerService;
    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public HomeController(OfferService offerService, UserService userService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView mv) {

        if (this.loggedUser.isEmpty()) {
            mv.setViewName("redirect:/");
            return mv;
        }

        List<OfferModel> userOffers = userService.findOfferByUserId(loggedUser.getId());
        List<OfferModel> boughtOffers = userService.findBoughtOfferByUserId(loggedUser.getId());
        List<OfferModel> otherUsersOffers = userService.findOtherOfferByUserId(loggedUser.getId());

        mv.setViewName("home");
        mv.addObject("userOffers", userOffers);
        mv.addObject("boughtOffers", boughtOffers);
        mv.addObject("otherUsersOffers", otherUsersOffers);
        mv.addObject("user", this.loggedUser);

        return mv;
    }

    @GetMapping()
    public String getIndex() {

        if (!this.loggedUser.isEmpty()) {
            return "redirect:/home";
        }

        return "index";
    }
}
