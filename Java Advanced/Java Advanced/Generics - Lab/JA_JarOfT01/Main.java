package JA_JarOfT01;

public class Main {
    public static void main(String[] args) {
    Jar<Integer> jar = new Jar<>();
    jar.add(33);
    jar.add(66);
    jar.add(99);
        System.out.println(jar.remove());
    }
}
