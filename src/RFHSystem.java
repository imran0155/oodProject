
import java.util.*;
public class RFHSystem {
    private List<User> users;
    private Map<String, List<Product>> productsByCategory;

    public RFHSystem() {
        this.users = new ArrayList<>();
        this.productsByCategory = new HashMap<>();
        // Initialize products
        List<Product> menProducts = new ArrayList<>();
        menProducts.add(new Product("Lungi", "For Men"));
        menProducts.add(new Product("Panjabi", "For Men"));
        menProducts.add(new Product("Shirt", "For Men"));
        menProducts.add(new Product("T-shirt", "For Men"));
        productsByCategory.put("men", menProducts);

        List<Product> womenProducts = new ArrayList<>();
        womenProducts.add(new Product("Saree", "For Women"));
        womenProducts.add(new Product("Kamiz", "For Women"));
        womenProducts.add(new Product("Burkha", "For Women"));
        productsByCategory.put("women", womenProducts);
    }

    public void registerUser(String username, String password) {
        users.add(new User(username, password));
    }

    public List<Product> getProductsByCategory(String category) {
        return productsByCategory.getOrDefault(category, new ArrayList<>());
    }
}

