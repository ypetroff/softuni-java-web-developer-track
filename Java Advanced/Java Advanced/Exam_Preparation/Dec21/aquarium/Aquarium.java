package Dec21.aquarium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aquarium {

    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size; //pool volume

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new HashMap<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public Aquarium(Map<String, Fish> fishInPool, String name, int capacity) {
        this.fishInPool = new HashMap<>();
        this.name = name;
        this.capacity = capacity;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {

        if (!this.fishInPool.containsKey(fish.getName()) && this.fishInPool.size() < this.capacity) {
            this.fishInPool.put(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {

        if(this.fishInPool.containsKey(name)) {
            this.fishInPool.remove(name);
            return true;
        }

        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.values().stream()
                .filter(f -> f.getName().equals(name))
                .findAny().orElse(null);
    }

    public String report() {
     return String.format("Aquarium: %s ^ Size: %d%n%s",
             this.name, this.size, this.fishInPool.values().stream()
                     .map(Fish::toString)
                     .collect(Collectors.joining(System.lineSeparator())));
    }
}
