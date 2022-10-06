package Google07;

public class Children {
    private final String name;
    private final String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
