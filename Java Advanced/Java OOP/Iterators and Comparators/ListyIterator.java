import java.util.List;

public class ListyIterator {
    private int index;
    private final List<String> data;

    public ListyIterator(List<String> data) {
        this.data = data;
    }


    public  void print(){
        validatePrint();
        System.out.println(this.data.get(index));
    }

    private void validatePrint(){
        if(this.data.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    public boolean move(){
        if(hasNext()){
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return index<data.size()-1;
    }
}
