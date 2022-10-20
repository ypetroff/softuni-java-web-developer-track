package lab.codingTracker;

public class Tracker {

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<Tracker> clazz)  {

        System.out.printf("%s: %s()%n"
                , Main.class.getMethods()[0].getAnnotation(Author.class).name()
                , Main.class.getMethods()[0].getName());
        System.out.printf("%s: %s()%n"
                , clazz.getMethods()[0].getAnnotation(Author.class).name()
                , clazz.getMethods()[0].getName());

    }
}
