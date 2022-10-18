package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        StringBuilder sbAddCollection = new StringBuilder();
        StringBuilder sbAddRemoveCollection = new StringBuilder();
        StringBuilder sbMyList = new StringBuilder();
        for (String s : input) {
            sbAddCollection.append(addCollection.add(s)).append(" ");
            sbAddRemoveCollection.append(addRemoveCollection.add(s)).append(" ");
            sbMyList.append(myList.add(s)).append(" ");
        }

        System.out.printf("%s%n%s%n%s%n", sbAddCollection, sbAddRemoveCollection, sbMyList);


        //  sbAddCollection.setLength(0);
        sbAddRemoveCollection.setLength(0);
        sbMyList.setLength(0);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            sbAddRemoveCollection.append(addRemoveCollection.remove()).append(" ");
            sbMyList.append(myList.remove()).append(" ");

        }

        System.out.printf("%s%n%s", sbAddRemoveCollection, sbMyList);

    }
}
