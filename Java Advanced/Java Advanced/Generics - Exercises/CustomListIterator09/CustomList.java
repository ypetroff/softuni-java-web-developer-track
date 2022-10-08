package CustomListIterator09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove (int index) {
      this.list.remove(index);
    }

    public boolean contains(T element) {
     return  this.list.contains(element);
    }

    public void swap (int index1, int index2) {
        Collections.swap(list, index1, index2);
    }

    public int countGreaterThan(T element) {
        return (int)list.stream().filter(x -> x.compareTo(element) > 0).count();
    }

    public T getMin() {
        isNotEmpty(this.list.size());
        return Collections.min(this.list);
    }

    private void isNotEmpty(int size) {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
    }

    public T getMax() {
        isNotEmpty(this.list.size());
        return Collections.max(this.list);
    }

public List<T> sort() {
        return this.list;
}

    public void print() {
        for (T t : list) {
            System.out.println(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
