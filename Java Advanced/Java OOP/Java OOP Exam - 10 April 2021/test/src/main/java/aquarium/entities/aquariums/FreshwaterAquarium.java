package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium implements Aquarium{

    public static final int DEFAULT_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
