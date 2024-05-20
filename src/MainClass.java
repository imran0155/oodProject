
import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        RFHSystem system = new RFHSystem();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        List<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to Resale Fashion Hub!");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Search products by collection");
            System.out.println("4. Add to cart");
            System.out.println("5. View cart");
            System.out.println("6. Payment method");
            System.out.println("7. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nRegistration:");
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    system.registerUser(username, password);
                    System.out.println("Registration successful.\n");
                    break;
                case 2:
                    System.out.println("\nLogin:");
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    // Validate user login (not shown for brevity)
                    user = new User(loginUsername, loginPassword);
                    System.out.println("Login successful.\n");
                    break;
                case 3:
                    System.out.println("\nSearch products by collection:");
                    System.out.println("1. Men");
                    System.out.println("2. Women");
                    System.out.print("Enter choice: ");
                    int categorySelection = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String selectedCategory = (categorySelection == 2) ? "women" : "men";
                    products = system.getProductsByCategory(selectedCategory);
                    System.out.println("\nAvailable products for " + (selectedCategory.equals("men") ? "men" : "women") + ":");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i).getName());
                    }
                    System.out.println();
                    break;
                case 4:
                    if (user == null) {
                        System.out.println("\nPlease log in first.\n");
                        break;
                    }
                    System.out.println("\nAdding product to cart:");
                    System.out.print("Enter product number: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (productNumber <= 0 || productNumber > products.size()) {
                        System.out.println("Invalid product number.\n");
                        break;
                    }
                    user.addToCart(products.get(productNumber - 1));
                    System.out.println("Product added to cart.\n");
                    break;
                case 5:
                    if (user == null) {
                        System.out.println("\nPlease log in first.\n");
                        break;
                    }
                    user.viewCart();
                    break;
                case 6:
                    if (user == null) {
                        System.out.println("\nPlease log in first.\n");
                        break;
                    }
                    user.choosePaymentMethod();
                    break;
                case 7:
                    System.out.println("\nLogout successful.\n");
                    user = null;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please choose a valid option.\n");
            }
        }
    }
}
