import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //start shopping cart program

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        double btwRate = 0.21; // 21% BTW
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

        double grandTotalExclBTW = 0;
        double grandTotalInclBTW = 0;
        System.out.println("\n--- Your Shopping Cart ---");
        for (int i = 0; i < items.size(); i++) {
            double priceExclBTW = prices.get(i);
            double subtotalExclBTW = priceExclBTW * quantities.get(i);
            double subtotalInclBTW = subtotalExclBTW * (1 + btwRate);

            grandTotalExclBTW += subtotalExclBTW;
            grandTotalInclBTW += subtotalInclBTW;

            System.out.println(quantities.get(i) + "x " + items.get(i) + " - Subtotal (excl. BTW): €" + String.format("%.2f", subtotalExclBTW));
            System.out.println("   Subtotal (incl. BTW): €" + String.format("%.2f", subtotalInclBTW));
        }
      // Display totals
        System.out.println("\n--- Total Amount ---");
        System.out.println("Total (excl. BTW): €" + String.format("%.2f", grandTotalExclBTW));
        System.out.println("BTW amount (21%): €" + String.format("%.2f", grandTotalInclBTW - grandTotalExclBTW));
        System.out.println("Total (incl. BTW): €" + String.format("%.2f", grandTotalInclBTW));

        System.out.print("Would you like to pay in USD? (yes/no): ");
        String convertToDollars = scanner.nextLine();

        if (convertToDollars.equalsIgnoreCase("yes")) {
            double exchangeRate = 1.07;
            double grandTotalDollars = grandTotalInclBTW * exchangeRate;
            System.out.println("Total in USD (incl. BTW): $" + String.format("%.2f", grandTotalDollars));
        }

        // Payment method

        System.out.print("Which payment method do you want to use? (paypal/credit card/Ideal): ");
        String paymentMethod = scanner.nextLine();
        System.out.println("You have chosen to pay with " + paymentMethod + ". Thank you for your purchase!");

        scanner.close();
    }
}


