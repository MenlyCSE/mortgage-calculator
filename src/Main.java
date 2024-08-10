import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static int monthsInYear = 12;
    final static int percent = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate (1% - 30%): ", 1, 30);
        int amountOfYears = (int) readNumber("Amount of years (1 - 30): ", 1, 30);

        // output
        printMortgage(principal, annualInterest, amountOfYears);
        printPaymentSchedule(amountOfYears, principal, annualInterest);
    }

    public static void printMortgage(int principal, float annualInterest, int amountOfYears) {
        double mortgage = calculateMortgage(principal, annualInterest, amountOfYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE:");
        System.out.println(mortgageFormatted);
    }

    public static void printPaymentSchedule(int amountOfYears, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE:");
        for (short month = 1; month <= amountOfYears * monthsInYear; month++) {
            double balance = calculateBalance(principal, annualInterest, amountOfYears, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner userInput = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = userInput.nextFloat();

            if (value >= min && value <= max)
                break;

            System.out.println("Please enter a number between " + min + " and " + max + "...");
        }

        return value;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            int amountOfYears,
            short numberOfPaymentsMade
    ) {
        int numberOfPayments = amountOfYears * monthsInYear;
        float monthlyInterest = annualInterest / percent / monthsInYear;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            int amountOfYears
    ) {
        int numberOfPayments = amountOfYears * monthsInYear;
        float monthlyInterest = annualInterest / percent / monthsInYear;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}