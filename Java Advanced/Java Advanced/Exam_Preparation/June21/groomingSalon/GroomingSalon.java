package June21.groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet petToRemove = findPet(name);

        if(petToRemove != null) {
            this.data.remove(this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null));
            return true;
        }
        return false;
    }

    private Pet findPet(String name) {
        return this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The grooming salon has the following clients:%n%s",
                this.data.stream().map(Pet::printPetAndOwner).collect(Collectors.joining(System.lineSeparator())));
    }
}
