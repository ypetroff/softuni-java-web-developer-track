package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish implements Fish { //TODO: Can only live in FreshwaterAquarium!

    private final static int DEFAULT_INITIAL_SIZE = 3;
    private final static int DEFAULT_INCREMENT = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(DEFAULT_INITIAL_SIZE);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + DEFAULT_INCREMENT);
    }
}
