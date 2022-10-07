package GenericScale03;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "z");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(101, 10*45);
        System.out.println(integerScale.getHeavier());
    }
}
