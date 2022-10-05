package BankAccount03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new HashMap<>();

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {

            String[] newData = command.split("\\s+");

            if ("Create".equals(newData[0])) {
                BankAccount bankAccount = new BankAccount();
                accounts.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());
                continue;
            } else if ("SetInterest".equals(newData[0])) {
                BankAccount.setInterestRate(Double.parseDouble(newData[1]));
                continue;
            }
            if(accounts.containsKey(Integer.parseInt(newData[1]))) {
                if ("Deposit".equals(newData[0])) {
                    int id = Integer.parseInt(newData[1]);
                    double amount = Double.parseDouble(newData[2]);
                    accounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                } else if ("GetInterest".equals(newData[0])) {
                    int id;
                    id = Integer.parseInt(newData[1]);
                    int years = Integer.parseInt(newData[2]);
                    System.out.printf("%.2f%n", accounts.get(id).getInterestRate(years));
                }
            } else {
                System.out.println("Account does not exist");
            }
        }

    }
}
