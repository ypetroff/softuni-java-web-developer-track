package Book01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Library implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book get(int index) {
        return this.books.get(index);
    }

    public int size() {
        return this.books.size();
    }
/*
    public Iterator<Book> iterator() {
        return books.iterator();
    } */

    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            private int index =0;
            @Override
            public boolean hasNext() {
                return index < books.size();
            }

            @Override
            public Book next() {
                return books.get(index++);
            }
        };
    }

 /*   private static class LibIterator implements Iterator<Book> {

        private int i = 0;
        private List<Book> books;

        public LibIterator(List<Book> books) {
            this.books = books;
        }


        @Override
        public boolean hasNext() {
            return i < books.size();
        }

        @Override
        public Book next() {
            return books.get(i++);
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(books);
    } */
}

