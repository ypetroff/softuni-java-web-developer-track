package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish implements Fish{ //TODO: Can only live in SaltwaterAquarium!
    private final static int DEFAULT_INITIAL_SIZE = 5;
    private final static int DEFAULT_INCREMENT = 2;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(DEFAULT_INITIAL_SIZE);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + DEFAULT_INCREMENT);
    }
}
