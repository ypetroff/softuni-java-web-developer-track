import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {

        verifyNameLength(name);
        this.name = name;
    }

    static void verifyNameLength(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {

        this.players.add(player);
    }

    public void removePlayer(String playerName) {

       if(players.stream().noneMatch(p -> p.getName().equals(playerName))) {
           throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
       }

        this.players.removeIf(p -> p.getName().equals(playerName));
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, Math.round(getRating()));
    }
}
