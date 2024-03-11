import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    private static ArrayList<ItemOrder> list = new ArrayList<>();

    public static void add(ItemOrder order) {
        list.add(order);
    }

    public static boolean remove(String itemName) {
        Iterator<ItemOrder> iterator = list.iterator();

        while (iterator.hasNext()) {
            ItemOrder order = iterator.next();
            if (order.getItem().getName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static boolean search(String itemName) {
        for (ItemOrder order : list) {
            if (order.getItem().getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public ItemOrder find(String itemName) {
        for (ItemOrder order : list) {
            if (order.getItem().getName().equals(itemName)) {
                return order;
            }
        }
        return null;
    }

    public static double getTotalPrice() {
        double total = 0;
        for (ItemOrder order : list) {
            total += order.getPrice();
        }
        return total;
    }
    public static ArrayList<ItemOrder> getOrders() {
        return new ArrayList<>(list);
    }
}
