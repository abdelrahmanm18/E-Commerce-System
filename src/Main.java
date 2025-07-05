import java.time.LocalDate;

public class Main {

    public static void checkout(Customer customer, Cart cart){

        if(cart.isEmpty()){
            throw new IllegalStateException("Cart is empty, Please add items to your cart");
        }

        if(customer.getBalance() <= 0 || cart.getOrderTotal() > customer.getBalance()){
            throw new IllegalStateException("Your balance is insufficient");
        }

        System.out.println("** Shipment notice **");
        cart.shippingService();

        System.out.println();

        System.out.println("** Checkout receipt **");


        System.out.println("---------------------");
        System.out.println("Subtotal\t\t" + cart.getSubTotal());
        System.out.println("Shipping\t\t" + cart.getShippingFees());
        System.out.println("Amount\t\t" + cart.getOrderTotal());

        customer.setBalance(customer.getBalance() - cart.getOrderTotal());
        System.out.println("Your current balance is\t" + customer.getBalance());


    }

    public static void main(String[] args) {

        Customer customer1 = new Customer(5000);
        Customer customer2 = new Customer(400);
        Customer customer3 = new Customer(0);

        //Shippable product with expiry date
        Product cheese = new Product("cheese", 25,12,400, LocalDate.parse("2025-07-01"));

        //Shippable product without expiry date
        Product TV = new Product("TV", 3000,1,5000);

        //not shippable product without expiry date
        Product MobileScratchCard = new Product("Mobile Scratch Card", 120,2,0);

        Product yogurt = new Product("Yogurt", 16,1,30, LocalDate.parse("2025-07-30"));
        Cart cart = new Cart();
        cart.add(TV, 1);
        cart.add(cheese, 120);
        cart.add(MobileScratchCard, 1);

        checkout(customer1,cart);

    }
}
