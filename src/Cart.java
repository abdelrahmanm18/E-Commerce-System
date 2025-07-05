import java.util.HashMap;
import java.util.Map;

public class Cart {
    HashMap<Product, Integer> shippedItems = new HashMap<>();
    private static int size = 0;
    private int subTotal;
    private int shippingFees;

    boolean isEmpty(){
        return size <= 0;
    }
    public int getOrderTotal(){
        return subTotal + shippingFees;
    }

    public void add(Product product, int Quantity){
        if(product.getAvaliableQuantity() < Quantity){
            throw new IllegalArgumentException("The selected item is out of stock, the available quantity is " +  product.getAvaliableQuantity());
            /*System.out.println("The selected item is out of stock, the available quantity is " +  product.getAvaliableQuantity());*/
        }

        if(product.isShippable()){
            addShippedItem(product, Quantity);
        }

        size++;
        product.setAvaliableQuantity(product.getAvaliableQuantity() - Quantity);
        calSubTotal(product, Quantity);
    }
    //helper method to calculate subtotal after adding every item.
    private void calSubTotal(Product product, int Quantity){
        subTotal += product.getPrice() * Quantity;
    }

    public int getSubTotal(){
        calFees();
        return subTotal;
    }


    //Helper method to add weighted items to the shippedItems map
    private void addShippedItem(Product product, int Quantity){
        shippedItems.put(product, shippedItems.getOrDefault(product,0) + Quantity);
    }


    /*
        i made assumptions about the shipping fees
        i will calculate the shipping fees based on the order subtotal
        The shipping fees will be %5 of the order subtotal
     */
    private void calFees(){
        double shippingPercentage = 0.05;
        shippingFees = (int) Math.ceil(subTotal * shippingPercentage);
    }

    public int getShippingFees(){
        return shippingFees;
    }

    public void shippingService(){
        Service service = new Service(shippedItems);
        service.shipItems();
    }




}
