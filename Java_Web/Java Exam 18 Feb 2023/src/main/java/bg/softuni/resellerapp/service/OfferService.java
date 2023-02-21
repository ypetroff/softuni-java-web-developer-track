package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.ConditionModel;
import bg.softuni.resellerapp.model.OfferModel;
import bg.softuni.resellerapp.model.UserModel;
import bg.softuni.resellerapp.model.binding.OfferAddModel;
import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.repository.OfferRepository;
import bg.softuni.resellerapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ConditionService conditionService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public OfferService(OfferRepository offerRepository, UserService userService, ConditionService conditionService,
                        ModelMapper modelMapper, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.conditionService = conditionService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void addOffer(OfferAddModel offerAddModel) {

        ConditionModel conditionModel = this.conditionService.findByName(offerAddModel.getCondition());
        UserModel userModel = this.userService.findUserById(this.loggedUser.getId());

        Offer offer = this.modelMapper.map(OfferModel.builder()
                        .description(offerAddModel.getDescription())
                        .price(offerAddModel.getPrice())
                        .condition(conditionModel)
                        .buyer(userModel)
                        .build(),
                 Offer.class);

        this.offerRepository.saveAndFlush(offer);

         this.userService.persistOfferToUser(offer, loggedUser.getId());
    }

    public void deleteItem(Long id) {
        this.offerRepository.deleteById(id);
    }

    public void buyItem(Long id) {

        Offer offerDB = this.offerRepository.findById(id).get();



        User seller = this.userService.getByUsername(offerDB.getSeller().getUsername()).get();
        User buyer = this.userService.getById(this.loggedUser.getId()).get();


        seller.getOffers().remove(offerDB);
        buyer.getBoughtOffers().add(offerDB);
        seller.removeOffer(offerDB);
        buyer.addBoughtOffer(offerDB);
        offerDB.setSeller(buyer);
        this.userService.saveBuyerAndSeller(buyer, seller);
        this.offerRepository.saveAndFlush(offerDB);


    }
}
