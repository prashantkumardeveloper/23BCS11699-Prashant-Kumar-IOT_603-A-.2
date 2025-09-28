import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private double price;
    private String category;

    // Constructor
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s'}", name, price, category);
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        // Dataset of products
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 35000, "Electronics"),
            new Product("Tablet", 25000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Jeans", 2500, "Clothing"),
            new Product("Jacket", 5000, "Clothing"),
            new Product("Fiction Book", 600, "Books"),
            new Product("Science Book", 1200, "Books")
        );

        // 1. Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products Grouped by Category:");
        productsByCategory.forEach((category, list) -> {
            System.out.println(category + " -> " + list);
        });

        // 2. Find the most expensive product in each category
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        System.out.println("\nMost Expensive Product in Each Category:");
        maxByCategory.forEach((category, product) ->
            System.out.println(category + " -> " + product.orElse(null))
        );

        // 3. Calculate the average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
