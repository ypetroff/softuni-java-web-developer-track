package Feb20.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {

        if(this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public  void promotePlayer(String name) {
        this.roster.stream().filter(p -> p.getName().equals(name)).findFirst().ifPresent(p -> p.setRank("Member"));
    }

    public void  demotePlayer(String name) {
        this.roster.stream().filter(p -> p.getName().equals(name)).findFirst().ifPresent(p -> p.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] arr = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);
        setRoster(this.roster.stream().filter(p -> !p.getClazz().equals(clazz)).collect(Collectors.toList()));
        return arr;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        return  String.format("Players in the Feb20.guild: %s:%n%s",
                this.name, this.roster.stream().map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
