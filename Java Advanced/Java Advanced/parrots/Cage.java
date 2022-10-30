package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setData(List<Parrot> data) {
        this.data = data;
    }

    public void add(Parrot parrot) {

        if(this.capacity > this.data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        this.data.stream().filter(p -> p.getName().equals(name)).findFirst().ifPresent(p -> p.setAvailable(false));
        return this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Parrot> sellParrotBySpecies(String species) {
      List<Parrot> soldParrots = this.data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
      setData(this.data.stream().filter(p -> !p.getSpecies().equals(species)).collect(Collectors.toList()));
      return soldParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        return String.format("Parrots available at %s:%n%s",
                this.name, this.data.stream().map(Parrot::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
