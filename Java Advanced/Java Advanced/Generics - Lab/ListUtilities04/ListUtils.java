package ListUtilities04;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>>T getMin(List<T> list) {
        checkListSize(list.isEmpty());
      return   Collections.min(list);
    }

    public static <T extends Comparable<T>>T getMax(List<T> list) {
        checkListSize(list.isEmpty());
      return   Collections.max(list);
    }

    private static void checkListSize(boolean empty) {
        if(empty){
            throw new IllegalArgumentException();
        }
    }
}
