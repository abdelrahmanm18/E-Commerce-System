import java.util.HashMap;
import java.util.Map;

public class Service{
    HashMap<Product, Integer> shippedItems;
    public Service(HashMap<Product, Integer> shippedItems){
        this.shippedItems = shippedItems;
    }
    public void shipItems(){
        int totalWeight = 0;

        for (Map.Entry<Product, Integer> entry : shippedItems.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            int itemWeight = (int) product.getWeight() * quantity;

            String unit = "g";
            if(itemWeight > 1000){
                itemWeight /= 1000;
                unit = "KG";
            }
            totalWeight += itemWeight;

            System.out.println(quantity + "x  " + product.getName() + "\t" + itemWeight + unit);
        }

        System.out.println("Total Package weight " + totalWeight + "KG");
    }


}
