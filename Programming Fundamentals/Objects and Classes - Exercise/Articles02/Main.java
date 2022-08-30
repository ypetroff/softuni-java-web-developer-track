package Articles02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialArticle = scanner.nextLine().split(", ");
        String title = initialArticle[0];
        String content = initialArticle[1];
        String author = initialArticle[2];

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Article article = new Article(title, content, author);
        for (int i = 0; i < numberOfCommands; i++) {

            String[] command = scanner.nextLine().split(": ");
            String action = command[0];
            String newItem = command[1];



            switch (action) {
                case "Edit":
                    article.edit(newItem);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newItem);
                    break;
                case "Rename":
                    article.rename(newItem);
                    break;
            }
        }
        article.override();
    }
}
