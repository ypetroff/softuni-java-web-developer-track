import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare (Book b1, Book b2) {
        int result = b1.getTitle().compareTo(b2.getTitle());
        return result != 0 ? result : Integer.compare(b1.getYear(), b2.getYear());
    }

}
