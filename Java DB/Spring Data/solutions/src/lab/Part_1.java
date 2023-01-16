package lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Part_1 {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = scanner.nextLine().trim();
        System.out.println();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", properties);

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employees WHERE salary > ?");

        System.out.print("Enter salary:");
        String salary = scanner.nextLine();
        statement.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " "
                    + rs.getString("last_name"));
        }

        connection.close();
    }
}
