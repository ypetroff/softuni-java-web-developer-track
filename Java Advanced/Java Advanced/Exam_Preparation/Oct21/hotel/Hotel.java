package Oct21.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {

    private final List<Person> roster;
    private final String name;
    private final int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if(roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {

        if (roster.stream().anyMatch(p -> p.getName().equals(name))) {
            roster.remove(roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null));
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream()
                .filter(person -> person.getName().equals(name) &&
                         person.getHometown().equals(hometown))
                .findFirst().orElse(null);

    }

    public int getCount() {
        return this.roster.size();
    } //clear

    public String getStatistics() { //clear
        return String.format("The people in the Oct21.hotel %s are:%n%s%n",
                this.name,roster.stream().map(Person::toString)
                .collect(Collectors.joining(System.lineSeparator())));

    }

}
