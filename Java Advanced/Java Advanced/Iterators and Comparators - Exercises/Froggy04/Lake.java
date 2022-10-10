package Froggy04;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{

    private List<Integer> lake;

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

  /*  private class Frog {

    }*/


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < lake.size();
            }

            @Override
            public Integer next() {
               int current = lake.get(index);
                index+=2;
               if(index % 2 == 0 && index>= lake.size()) {
                   index = 1;
               }

                return current;
            }
        };
    }
}
