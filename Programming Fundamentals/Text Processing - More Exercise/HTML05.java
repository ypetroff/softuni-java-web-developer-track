import java.util.Scanner;

public class HTML05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.printf("<h1>%n" +
                            "    %s%n" +
                            "</h1>%n", title);
        System.out.printf("<article>%n" +
                            "    %s%n" +
                            "</article>%n", content);
        String comments;

        while (!"end of comments".equals(comments = scanner.nextLine())) {

            System.out.printf("<div>%n" +
                    "    %s%n" +
                    "</div>%n", comments);

        }
    }
}
