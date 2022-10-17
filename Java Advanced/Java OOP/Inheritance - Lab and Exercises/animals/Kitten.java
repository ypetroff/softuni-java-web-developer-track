package animals;

public class Kitten extends Cat {

    final static String DEFAULT_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, DEFAULT_GENDER);

    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
