import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // currency: $1,234,567
        // slashes: 0.1 --> 10%
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("You are " + name);
    }
}