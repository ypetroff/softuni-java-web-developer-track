package EqualityLogic07;

import java.util.Comparator;

public class CompareByHashCode implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}
