import java.time.LocalDate;
import java.util.Date;

public class Product implements ShippableProduct{
    private String name;
    private int price;
    private int avaliableQuantity;
    private double weight;
    private LocalDate expiryDate;

    public Product(String name, int price, int avaliableQuantity, double weight){
        this.name = name;
        this.price = price;
        this.avaliableQuantity = avaliableQuantity;
        this.weight = weight;
    }

    public Product(String name, int price, int avaliableQuantity, double weight, LocalDate expiryDate){
        this.name = name;
        this.price = price;
        this.avaliableQuantity = avaliableQuantity;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(int avaliableQuantity) {
        this.avaliableQuantity = avaliableQuantity;
    }

    public boolean isExpired(){
        return expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }

    public boolean isShippable() {
        return weight > 0;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
