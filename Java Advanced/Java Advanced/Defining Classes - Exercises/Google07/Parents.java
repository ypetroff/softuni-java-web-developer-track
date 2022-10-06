package Google07;

public class Parents {
    private final String name;
    private final String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
