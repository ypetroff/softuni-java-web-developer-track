package Collection02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private static int internalIndex = 0;

    public ListyIterator(List<String> list) {
        this.list = list;
    }

    private void setList(String... list) {
        this.list = Arrays.asList(list);
    }

    public boolean move() {

      /*  if(hasNext()) {
            internalIndex++;
            return true;
        }
        return false; */
       if (internalIndex < list.size() - 1) {
            internalIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return internalIndex < (list.size() - 1);
    }

    @Override
    public String toString() {
        return String.join(" ", this.list);
    }

    public void print() {
        validate();
        System.out.println(this.list.get(internalIndex));
    }

    private void validate() {
        if(this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size(); //-1
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }

    public void printAll() {
        validate();
        list.forEach(e -> System.out.printf("%s ", e));
        System.out.println();
    }
}
