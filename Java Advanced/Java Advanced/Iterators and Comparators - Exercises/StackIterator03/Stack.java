package StackIterator03;

import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {

    private Node top;

    private static class Node {
        private final int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
            this.prev = null;
        }
    }

    public void push(int element) {
        Node newElement = new Node(element);
        if(this.top != null) {
            newElement.prev = this.top;
        }
            this.top = newElement;
    }

    public int pop() {
        if(this.top == null) {
            throw new IllegalStateException("No elements");
        }
        Node currentNode = this.top;
        this.top = this.top.prev;
        return currentNode.element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return (Iterator<Integer>) new Iterator<java.lang.Integer>() {
            private Node currentNode = top;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public java.lang.Integer next() {
                int element = currentNode.element;
                currentNode = currentNode.prev;
                return element;
            }
        };
    }
}
