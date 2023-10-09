package br.com.himuro.shopping.Application;

import br.com.himuro.shopping.Models.CreditCard;
import br.com.himuro.shopping.Models.Transaction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the card limit: ");
        double limit = sc.nextDouble();
        System.out.println();
        CreditCard creditCard = new CreditCard(limit);
        int i = -1;
        while (i != 0){
            try {
                sc.nextLine();
                System.out.print("Enter the purchase description: ");
                String purchaseDescription = sc.nextLine();

                System.out.print("Enter the purchase value: ");
                double purchaseValue = sc.nextDouble();
                Transaction transaction = new Transaction(purchaseDescription, purchaseValue);
                boolean isTransactionCompleted = creditCard.addTransaction(transaction);
                if (isTransactionCompleted){
                    System.out.println("Purchase completed!");
                }
                else {
                    System.out.println("Insufficient Balance!");
                }
                System.out.println("Press 0 to exit or 1 to continue");
                i = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        creditCard.showPurchases();
    }
}
