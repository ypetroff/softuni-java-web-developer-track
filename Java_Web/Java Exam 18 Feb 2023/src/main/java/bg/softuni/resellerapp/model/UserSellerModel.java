package bg.softuni.resellerapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserSellerModel {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Set<OfferModel> offers;

    private Set<OfferModel> boughtOffers;
}
