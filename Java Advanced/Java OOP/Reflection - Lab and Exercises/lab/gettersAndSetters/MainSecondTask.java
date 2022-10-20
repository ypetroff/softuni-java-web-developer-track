package lab.gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class MainSecondTask {

    private static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method m1, Method m2) {
            boolean m1IsGetter = m1.getName().startsWith("get");
            boolean m2IsGetter = m2.getName().startsWith("get");

            if (m1IsGetter && m2IsGetter) {
                return m1.getName().compareTo(m2.getName());
            }

            boolean m1IsSetter = m1.getName().startsWith("set");
            boolean m2IsSetter = m2.getName().startsWith("set");

            if (m1IsSetter && m2IsSetter) {
                return m1.getName().compareTo(m2.getName());
            }

            return Boolean.compare(m2IsGetter, m1IsGetter);
        }
    }

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(MainSecondTask::print);

      /*  System.out.println("********************************");

          Arrays.stream(lab.reflection.Reflection.class.getDeclaredMethods())
                .filter(current->current.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.printf("%s will return class %s%n"
                        ,getter.getName(),getter.getReturnType().getName()));

        Arrays.stream(lab.reflection.Reflection.class.getDeclaredMethods())
                .filter(current->current.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.printf("%s and will set field of class %s%n"
                        ,setter.getName(),setter.getParameters()[0].getType().getName()));

*/
    }

    private static void print(Method method) {
        String output = method.getName().startsWith("get")
                ? String.format("%s will return class %s",
                method.getName(), method.getReturnType().getName())
                : String.format("%s and will set field of class %s",
                method.getName(), method.getParameterTypes()[0].getName());

        System.out.println(output);
    }
}
