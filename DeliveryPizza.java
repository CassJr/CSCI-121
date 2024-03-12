public class DeliveryPizza extends Pizza {
    private double deliveryFee;

    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, int numberOfToppings, String deliveryAddress) {
        super(toppings, numberOfToppings);

        this.deliveryAddress = deliveryAddress;

        if (this.price > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }


    public String toString() {
        return super.toString() + " " + "\nDelivery Address: " + " " + deliveryAddress + " " + "\nDelivery Fee: $" + deliveryFee + " " + "\nTotal Price: $" + (this.price + this.deliveryFee);
    }
}
