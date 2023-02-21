package bg.softuni.resellerapp.controller;

import bg.softuni.resellerapp.model.OfferModel;
import bg.softuni.resellerapp.model.UserModel;
import bg.softuni.resellerapp.model.binding.OfferAddModel;
import bg.softuni.resellerapp.service.OfferService;
import bg.softuni.resellerapp.service.UserService;
import bg.softuni.resellerapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping ("/offers")
public class OfferController {

    private final UserService userService;
    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public OfferController(UserService userService, OfferService offerService, LoggedUser loggedUser) {
        this.userService = userService;
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public String getOffer() {

        if (this.loggedUser.isEmpty()) {
            return "redirect:/login";
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String postAddOffer(@Valid @ModelAttribute(name = "offerAddModel") OfferAddModel offerAddModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddModel", offerAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddModel",
                            bindingResult);

            return "redirect:add";
        }


        this.offerService.addOffer(offerAddModel);

        return "redirect:/home";
    }

    @GetMapping("buy/{id}")
    public String buyOffer(@PathVariable Long id) {

        if (this.loggedUser.isEmpty()) {
            return "redirect:/login";
        }

        this.offerService.buyItem(id);

        return "redirect:/home";
    }

    @GetMapping("remove/{id}")
    public String removeOffer(@PathVariable Long id) {

        if (this.loggedUser.isEmpty()) {
            return "redirect:/login";
        }

        this.offerService.deleteItem(id);

        return "redirect:/home";
    }

    @ModelAttribute(name = "offerAddModel")
    public OfferAddModel offerAddModel() {
        return new OfferAddModel();
    }
}
