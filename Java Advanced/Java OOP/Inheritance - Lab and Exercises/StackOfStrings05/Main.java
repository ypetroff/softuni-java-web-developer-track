package StackOfStrings05;

public class Main {
    public static void main(String[] args) {


        StackOfStrings stack = new StackOfStrings();

        for (int i = 23; i < 546; i*=3) {
            stack.push(String.valueOf(i));
        }

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
