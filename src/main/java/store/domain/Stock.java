package store.domain;

public class Stock {
    private String name;
    private double price;
    private int quantity;
    private String promotion;

    public Stock(String name, double price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getPromotion() {
        return promotion;
    }
}
