package lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Part_2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

      /*  System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = scanner.nextLine().trim();
        System.out.println(); */

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement statement = connection.prepareStatement(
                """
                        SELECT\s
                            CONCAT_WS(' ', u.first_name, u.last_name) AS full_name,
                            (SELECT\s
                                    COUNT(*)
                                FROM
                                    users_games AS ug
                                WHERE
                                    ug.user_id = u.id) AS games
                        FROM
                            users AS u
                        WHERE
                            u.user_name = ?""");


        System.out.print("Enter username:");
        String username = scanner.nextLine();
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.println(username);
            System.out.printf("%s has played %d games", rs.getString("full_name"),
                    rs.getInt("games"));
        } else {
            System.out.println("No such user exists");
        }

        connection.close();
    }
}
