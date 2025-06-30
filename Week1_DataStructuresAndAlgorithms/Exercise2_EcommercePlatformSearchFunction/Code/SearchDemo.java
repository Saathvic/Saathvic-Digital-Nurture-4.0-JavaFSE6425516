package EcommerceSearch;
import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    // Linear Search by product name
    public static Product linearSearch(Product[] productArray, String searchName) {
        for (Product currentProduct : productArray) {
            if (currentProduct.productName.equalsIgnoreCase(searchName)) {
                return currentProduct;
            }
        }
        return null;
    }

    // Binary Search by product name
    public static Product binarySearch(Product[] productArray, String searchName) {
        int leftIndex = 0;
        int rightIndex = productArray.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int comparison = searchName.compareToIgnoreCase(productArray[middleIndex].productName);

            if (comparison == 0)
                return productArray[middleIndex];
            else if (comparison < 0)
                rightIndex = middleIndex - 1;
            else
                leftIndex = middleIndex + 1;
        }
        return null;
    }    public static void main(String[] args) {
        Product[] productCatalog = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        // Linear Search
        System.out.println("Linear Search Result:");
        Product linearResult = linearSearch(productCatalog, "Mobile");
        System.out.println(linearResult != null ? linearResult : "Product not found");

        // Sort products for binary search
        Arrays.sort(productCatalog, Comparator.comparing(product -> product.productName.toLowerCase()));

        // Binary Search
        System.out.println("\nBinary Search Result:");
        Product binaryResult = binarySearch(productCatalog, "Mobile");
        System.out.println(binaryResult != null ? binaryResult : "Product not found");
    }
}
