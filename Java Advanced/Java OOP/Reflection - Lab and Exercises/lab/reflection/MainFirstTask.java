package lab.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MainFirstTask {
    public static void main(String[] args) {


        try {
            Class<Reflection> clazz = Reflection.class;
            System.out.println(clazz);

            Class<?> superClazz = clazz.getSuperclass();
            System.out.println(superClazz);

            Class<?>[] interfaces = clazz.getInterfaces();
            Arrays.stream(interfaces).forEach(System.out::println);

            Constructor<Reflection> constructor = clazz.getDeclaredConstructor();

        //  constructor.setAccessible(true);

            Reflection reflection = constructor.newInstance();

        //  Object obj = clazz.getDeclaredConstructor().newInstance();

            System.out.println(reflection);

        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
         //   System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }
}
