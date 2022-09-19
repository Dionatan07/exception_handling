package application;

import exceptions.BusinessException;
import model.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner key = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = key.nextInt();
        key.nextLine();
        System.out.print("Holder: ");
        String holder = key.nextLine();
        System.out.print("Initial balance: ");
        double balance = key.nextDouble();
        System.out.print("Withdraw limit: ");
        double limit = key.nextDouble();

        Account account = new Account(number, holder, balance, limit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = key.nextDouble();

        try {
            account.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f%n", account.getBalance()));
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }


    }
}
