package LinkedListTraversal09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T>{

    private List<T> list;

    public LinkedList(List<T> list) {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public boolean remove(T element) {
        if(this.list.contains(element)) {
            for (T t : list) {
                if(t.equals(element)) {
                    list.remove(t);
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return this.list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                index++;
                return list.get(index - 1);
            }
        };
    }
}
