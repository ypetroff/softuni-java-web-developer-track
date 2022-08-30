package Article04;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<Article2> collection = new ArrayList<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] addArticle = scanner.nextLine().split(", ");
            String title = addArticle[0];
            String content = addArticle[1];
            String author = addArticle[2];

            Article2 article = new Article2(title, content, author);
            collection.add(article);
        }
        String reference = scanner.nextLine();
List<Article2> result = new ArrayList<>();
        switch (reference) {
            case "title":
               result = collection.stream().
                        sorted(Comparator.comparing(Article2::getTitle)).collect(Collectors.toList());
                break;
            case "content":
                result = collection.stream().
                        sorted(Comparator.comparing(Article2::getContent)).collect(Collectors.toList());
                break;
            case "author":
                result = collection.stream().
                        sorted(Comparator.comparing(Article2::getAuthor)).collect(Collectors.toList());
                break;
        }
        for (Article2 article2 : result) {
            article2.override();
        }
    }
}
