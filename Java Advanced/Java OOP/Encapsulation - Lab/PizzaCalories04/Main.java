package PizzaCalories04;

import java.util.Scanner;

public class Main {

    private static int numberOfToppings;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String temp = scanner.nextLine();
        String[] pizzaDetails = readArr(temp, "Pizza");

        try {
            Pizza pizza = new Pizza(pizzaDetails[0], Integer.parseInt(pizzaDetails[1]));

            temp = scanner.nextLine();
            String[] doughDetails = readArr(temp, "Dough");

            Dough dough = new Dough(doughDetails[0], doughDetails[1], Double.parseDouble(doughDetails[2]));
            pizza.setDough(dough);

            String command;
            while (!(command = scanner.nextLine()).equals("END") && numberOfToppings-- > 0) {

                String[] toppingDetails = readArr(command, "Topping");

                Topping topping = new Topping(toppingDetails[0], Double.parseDouble(toppingDetails[1]));
                pizza.addTopping(topping);
            }

            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    private static String[] readArr(String toSplit, String toRemove) {

        String[] temp = toSplit.replaceFirst(toRemove, "").trim().split("\\s+");

        if(toRemove.equals("Pizza")) {
            numberOfToppings = Integer.parseInt(temp[1]);
        }
        return temp;
    }
}

//    Pizza Meatless 1
//        Dough White Chewy 100
//        Topping Meat 50
//        END