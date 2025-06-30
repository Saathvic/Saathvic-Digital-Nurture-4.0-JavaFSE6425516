package DataStructureAndAlgorthms;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void show() {
        System.out.println(orderId + " - " + customerName + " - " + totalPrice);
    }
}

public class CustomerOrderSorting {    static void bubble(Order[] orders) {
        int length = orders.length;
        for (int outerIndex = 0; outerIndex < length - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < length - outerIndex - 1; innerIndex++) {
                if (orders[innerIndex].totalPrice < orders[innerIndex + 1].totalPrice) {
                    Order temp = orders[innerIndex];
                    orders[innerIndex] = orders[innerIndex + 1];
                    orders[innerIndex + 1] = temp;
                }
            }
        }
    }    static void quickSort(Order[] orders, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partitionIndex = partition(orders, leftIndex, rightIndex);
            quickSort(orders, leftIndex, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, rightIndex);
        }
    }

    static int partition(Order[] orders, int leftIndex, int rightIndex) {
        double pivot = orders[rightIndex].totalPrice;
        int smallerIndex = leftIndex - 1;
        for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++) {
            if (orders[currentIndex].totalPrice < pivot) {
                smallerIndex++;
                Order temporary = orders[smallerIndex];
                orders[smallerIndex] = orders[currentIndex];
                orders[currentIndex] = temporary;
            }
        }
        Order temporary = orders[smallerIndex + 1];
        orders[smallerIndex + 1] = orders[rightIndex];
        orders[rightIndex] = temporary;
        return smallerIndex + 1;
    }

    static void displayOrders(Order[] orders) {
        for (Order order : orders) order.show();
    }    public static void main(String[] args) {
        Order[] originalOrders = {
            new Order("OrderFirst", "Alice", 2000),
            new Order("OrderSecond", "Bob", 1800),
            new Order("OrderThird", "Charlie", 2500),
            new Order("OrderFourth", "David", 1600),
            new Order("OrderFifth", "Eve", 2200)
        };

        Order[] bubbleSortedOrders = originalOrders.clone();
        Order[] quickSortedOrders = originalOrders.clone();

        System.out.println("Bubble Sort (Descending):");
        bubble(bubbleSortedOrders);
        displayOrders(bubbleSortedOrders);

        System.out.println("\nQuick Sort (Ascending):");
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        displayOrders(quickSortedOrders);
    }
}
