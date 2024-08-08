import java.util.Scanner;

//        // currency: $1,234,567
//        // slashes: 0.1 --> 10%
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Name: ");
//        String name = scanner.nextLine().trim();
//        System.out.println("You are " + name);


public class Main {
    public static void main(String[] args) {
        // Principal (amount of loan)
        // Interest rate (%)
        // Period (Years)
        // Prints Monthly payments for mortgage in currency

        Scanner amountLoan = new Scanner(System.in); // input
        System.out.print("Amount of loan: "); // prompt
        String amountLoanRes = amountLoan.nextLine().trim(); // remove spaces & returns input
        System.out.println(amountLoanRes);
    }
}