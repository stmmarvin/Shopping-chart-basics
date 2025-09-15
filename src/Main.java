import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //start shopping cart program

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        // Shopping loop

        String continueShopping;
        do {
            System.out.print("Which item would you buy?");
            String item = scanner.nextLine();
            items.add(item);

            System.out.print("Which price does the item have?");
            double price = scanner.nextDouble();
            prices.add(price);

            System.out.print("Which quantities do the item have?");
            int quantity = scanner.nextInt();
            quantities.add(quantity);
            scanner.nextLine();

            System.out.print("Do you want to continue shopping? (yes/no)");
            continueShopping = scanner.nextLine();
        } while (continueShopping.equalsIgnoreCase("yes"));

        // Display cart summary

        double grandTotalEuros = 0;
        System.out.println("\n--- Your Shopping cart ---");
        for (int i = 0; i < items.size(); i++) {
            double subtotal = prices.get(i) * quantities.get(i);
            grandTotalEuros += subtotal;
            System.out.println(quantities.get(i) + "x " + items.get(i) + " - Subtotal: €" + String.format("%.2f", subtotal));
        }
        System.out.println("\n--- Total Amount ---");
        System.out.println("Total in Euros: €" + String.format("%.2f", grandTotalEuros));

        System.out.print("Would you like to pay in USD? (yes/no): ");
        string convertToDollars = scanner.nextLine();

        if (convertToDollars.equalsIgnoreCase("yes")) {
            double exchangeRate = 1.07; // Example exchange rate
            double grandTotalDollars = grandTotalEuros * exchangeRate;
            System.out.println("Total in USD: $" + String.format("%.2f", grandTotalDollars));
        }
    }
}



