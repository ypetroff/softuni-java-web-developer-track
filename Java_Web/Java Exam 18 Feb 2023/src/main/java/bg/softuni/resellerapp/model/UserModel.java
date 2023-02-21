package bg.softuni.resellerapp.model;

import bg.softuni.resellerapp.model.entity.Offer;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Set<OfferModel> offers;

    private Set<OfferModel> boughtOffers;

    private UserModel buyer;


}
