import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int monthsInYear = 12;
        final int percent = 100;

        // input object
        Scanner userInput = new Scanner(System.in);

        // user input - principal
        System.out.print("Principal: ");
        int principal = userInput.nextInt();

        // user input - annual interest rate
        System.out.print("Annual Interest Rate: ");
        float annualInterest = userInput.nextFloat();

        // user input - amount of years (period)
        System.out.print("Amount of years: ");
        int amountOfYears = userInput.nextInt();

        // calculating monthly interest, number of payments, and mortgage
        float monthlyInterest = annualInterest / percent / monthsInYear;
        int numberOfPayments = amountOfYears * monthsInYear;
        double mortgage = principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // output
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}