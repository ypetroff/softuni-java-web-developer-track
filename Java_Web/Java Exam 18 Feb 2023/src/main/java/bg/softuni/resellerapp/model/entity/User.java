package bg.softuni.resellerapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id",name = "seller_id")
    private Set<Offer> offers;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Offer> boughtOffers;

    public void addBoughtOffer(Offer offer) {
        this.boughtOffers.add(offer);
    }

    public void removeOffer(Offer offer) {
        this.offers.remove(offer);
    }
}
