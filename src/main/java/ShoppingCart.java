import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        System.out.println("Select language");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language selection. Defaulting to English.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.println(rb.getString("amount"));
        int amountItem = scanner.nextInt();

        ArrayList<Double> productCosts = new ArrayList<>();

        for (int i = 0; i < amountItem; i++) {
            System.out.println(rb.getString("price"));
            double price = scanner.nextDouble();
            System.out.println(rb.getString("quantity"));
            int quantity = scanner.nextInt();
            productCosts.add(price * quantity);
        }

        double totalPrice = sumPrices(productCosts);
        System.out.println(rb.getString("totalcost") + totalPrice);
    }

    public static double sumPrices(ArrayList<Double> costs) {
        double total = 0;
        for (Double cost : costs) {
            total += cost;
        }
        return total;
    }
}
