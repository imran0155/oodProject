
import java.util.*;

public class User {
    private String username;
    private String password;
    private List<Product> cart;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }
    public void addToCart(Product product) {
        cart.add(product);
    }
    public void viewCart() {
        System.out.println("\nViewing Cart:");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product product : cart) {
                System.out.println("- " + product.getName());
            }
            System.out.println("You will receive your delivery within 3 days.");
        }
    }

    public void choosePaymentMethod() {
        System.out.println("\nPayment Method:");
        System.out.println("1. Pay with Online");
        System.out.println("2. Cash on Delivery");
        System.out.print("Choose payment method: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {

            case 1:
                System.out.println("Thanks for being with us! You have chosen to pay online.");
                break;
            case 2:
                System.out.println("Thanks for being with us! You have chosen cash on delivery.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
