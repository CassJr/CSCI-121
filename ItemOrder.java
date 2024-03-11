public class ItemOrder {
    private Item item;
    private int quantity;


    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }


    public double getPrice() {
        if (quantity <= 2) {
            return item.getPrice() * quantity;
        } else {

            double priceForFirstTwo = item.getPrice() * 2;
            double priceForAdditional = (quantity - 2) * (item.getPrice() / 2.0);
            return priceForFirstTwo + priceForAdditional;
        }

    }
}
