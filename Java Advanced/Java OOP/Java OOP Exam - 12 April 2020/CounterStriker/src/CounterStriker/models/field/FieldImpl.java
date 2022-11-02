package CounterStriker.models.field;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream()
                .filter(p -> !p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());

        while (AreAlive(terrorists) && AreAlive(counterTerrorists)) {

//            shooting(terrorists, counterTerrorists);
//
//            if (!AreAlive(counterTerrorists)) {
//                return TERRORIST_WINS;
//            }
//
//            shooting(counterTerrorists, terrorists);
//
//        }
//        return COUNTER_TERRORIST_WINS;

            terrorists.stream().filter(Player::isAlive).<Consumer<? super Player>>map(terrorist -> player ->
                    player.takeDamage(terrorist.getGun().fire())).forEach(counterTerrorists::forEach);

            counterTerrorists.stream().filter(Player::isAlive).<Consumer<? super Player>>map(contraTerrorist -> player ->
                    player.takeDamage(contraTerrorist.getGun().fire())).forEach(terrorists::forEach);

    }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;

//    private void shooting(List<Player> attackers, List<Player> defenders) {
//        attackers.stream()
//                .filter(Player::isAlive)
//                .forEach(attacker -> {
//                    int fire = attacker.getGun().fire();
//                    defenders.stream().filter(Player::isAlive).forEach(defender -> defender.takeDamage(fire));
//                });
    }

    private boolean AreAlive(List<Player> players) {
        return players.stream().anyMatch(Player::isAlive);
    }


}
