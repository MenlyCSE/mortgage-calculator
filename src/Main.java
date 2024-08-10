import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int monthsInYear = 12;
        final int percent = 100;
        int principal = 0;
        int amountOfYears = 0;
        int numberOfPayments = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        Scanner userInput = new Scanner(System.in);

        // loop - principal
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = userInput.nextInt();

            if (principal >= 1_000 && principal <= 1_000_000)
                break;

            System.out.println("Please enter a number between $1 and $1,000,000...");
        }

        // loop - annual & monthly interest rate
        while (true) {
            System.out.print("Annual Interest Rate (1% - 30%): ");
            annualInterest = userInput.nextFloat();

            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / percent / monthsInYear;
                break;
            }

            System.out.println("Please enter a number between 1% and 30%...");
        }

        // user input - amount of years (period)
        while (true) {
            System.out.print("Amount of years (1 - 30): ");
            amountOfYears = userInput.nextInt();

            if (amountOfYears >= 1 && amountOfYears <= 30) {
                numberOfPayments = amountOfYears * monthsInYear;
                break;

            }

            System.out.println("Please enter a number between 1 and 30...");
        }

        // calculating monthly interest, number of payments, and mortgage
        double mortgage = principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // output
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}