package BankAccount03;

public class BankAccount {
    private static int idCount = 1;
    private static double interestRate = 0.02;

    private double balance;
    private int id;

    public BankAccount() {
        this.id = idCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }


    public double getInterestRate(int years) {
        return this.balance * BankAccount.interestRate * years;

    }

//    public double getBalance() {
//        return balance;
//    }

    public int getId() {
        return id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
