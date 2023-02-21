package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.ConditionModel;
import bg.softuni.resellerapp.model.OfferModel;
import bg.softuni.resellerapp.model.OfferRenderModel;
import bg.softuni.resellerapp.model.UserModel;
import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public boolean findUserByEmail(String email) {

        return this.userRepository.findByEmail(email).isEmpty();

    }

    public boolean findUserIsPresentByUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    public UserModel findUserByUsername(String username) {
        Optional<User> userDB = getByUsername(username);

        if(userDB.isEmpty()) {
            return new UserModel();
        }

       return this.modelMapper.map(userDB.get(), UserModel.class);
    }

    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }


    public List<OfferModel> findOfferByUserId(Long id) {
        Optional<User> user = getById(id);

        if(user.isEmpty()) {
            return null;
        }

        List<OfferModel> own = user.get().getOffers().stream()
                .map(offer -> this.modelMapper.map(offer, OfferModel.class)).collect(Collectors.toList());
        List<OfferModel> bought = findBoughtOfferByUserId(id);

        if(own.size() > 0) {
            own.removeAll(bought);
        }


        return own;
    }

    public List<OfferModel> findBoughtOfferByUserId(Long id) {
        Optional<User> user = getById(id);

        if(user.isEmpty()) {
            return null;
        }


        return user.get().getBoughtOffers().stream()
                .map(offer -> this.modelMapper.map(offer, OfferModel.class)).toList();
    }

    public List<OfferModel> findOtherOfferByUserId(Long id) {

        Optional<List<User>> allByIdNot = this.userRepository.findAllByIdNot(id);

        List<OfferModel> offers = new ArrayList<>();

        if (allByIdNot.isEmpty()) {
            return new ArrayList<>();
        }

        for (User user : allByIdNot.get()) {

            List<Offer> offersOfUser = new ArrayList<>(user.getOffers());
            List<Offer> boughtByUser = new ArrayList<>(user.getBoughtOffers());

            offersOfUser.removeAll(boughtByUser);

            for (Offer offer : offersOfUser) {

                ConditionModel conditionModel = this.modelMapper.map(offer.getCondition(), ConditionModel.class);

                OfferModel model = new OfferModel();
                model.setId(offer.getId());
                model.setDescription(offer.getDescription());
                model.setPrice(offer.getPrice());
                model.setCondition(conditionModel);
                model.setBuyer(this.modelMapper.map(user, UserModel.class));

                offers.add(model);
            }

        }

        return offers;
    }

    public UserModel findUserById(Long id) {

        return this.modelMapper.map(getById(id), UserModel.class);
    }

    public Optional<User> getById(Long id) {
        return this.userRepository.findById(id);
    }

    public void persistOfferToUser(Offer offer, Long id) {

        Optional<User> user = getById(id);

        user.ifPresent(value -> value.getOffers().add(offer));

        this.userRepository.saveAndFlush(user.get());
    }

    public void saveBuyerAndSeller(User buyer, User seller) {

        List<User> users = List.of(buyer, seller);

        this.userRepository.saveAllAndFlush(
                users
        );
    }
}
