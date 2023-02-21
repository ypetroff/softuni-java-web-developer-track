package bg.softuni.resellerapp.repository;


import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.enums.ConditionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferByDescriptionAndAndPriceAndAndCondition(
            String description, BigDecimal price, ConditionEnum condition);
}
