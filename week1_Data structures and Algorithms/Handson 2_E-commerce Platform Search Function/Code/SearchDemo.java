package EcommerceSearch;
import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    // Linear Search by product name
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by product name
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        // Linear Search
        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, "Mobile");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort products for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, "Mobile");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
