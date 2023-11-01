import java.util.HashMap;
import java.util.Map;

class GroceryStore {
    private Map<String, Integer> stock;
    private Map<String, Double> prices;

    public GroceryStore() {
        stock = new HashMap<>();
        prices = new HashMap<>();
    }

    public void addToStock(String itemName, int quantity) {
        // Add items to stock
        stock.put(itemName, stock.getOrDefault(itemName, 0) + quantity);
    }

    public void setPrice(String itemName, double pricePerUnit) {
        // Set the price for an item
        prices.put(itemName, pricePerUnit);
    }

    public void displayStock() {
        // Display stock maintenance
        System.out.println("Stock Maintenance:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " units");
        }
    }

    public void displayPriceInformation() {
        // Display price information
        System.out.println("Price Information:");
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue() + " per unit");
        }
    }

    public double calculateTotalPrice(String itemName, int quantity) {
        // Calculate the total price for a customer
        if (stock.containsKey(itemName) && stock.get(itemName) >= quantity && prices.containsKey(itemName)) {
            return prices.get(itemName) * quantity;
        } else {
            System.out.println("Item not available or insufficient quantity.");
            return 0.0;
        }
    }

    public static void main(String[] args) {
        GroceryStore store = new GroceryStore();

        // Add items to stock
        store.addToStock("Apples", 50);
        store.addToStock("Bananas", 30);

        // Set prices for items
        store.setPrice("Apples", 1.99);
        store.setPrice("Bananas", 0.99);

        // Display stock maintenance and price information
        store.displayStock();
        store.displayPriceInformation();

        // Calculate unit-wise price for a customer
        String item = "Apples";
        int quantity = 5;
        double totalPrice = store.calculateTotalPrice(item, quantity);
        System.out.println("Total Price for " + quantity + " " + item + ": $" + totalPrice);
    }
}

