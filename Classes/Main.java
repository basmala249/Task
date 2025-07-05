package Classes; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map; 
public class Main {
    public static void main(String[] args) {
        Store store = new Store() ;
        Product p1 = new Product("cheese", 3, 100, 70.0 , 50.0);
        Product p2 = new Product("tv", 1, 6, 12500.0 , 200.0);
        Product p3 = new Product("mobile", 2, 5, 8700.0 , 60.0);
        Product p4 = new Product("milk", 4, 2, 56.5 , 2.0);
        p4.setExpire("12-7-2024");
        ManagerAccount managerAccount = new ManagerAccount();
        managerAccount.addAccess(0 , 12);
        managerAccount.addNewProduct(0 , p1 , store);
        managerAccount.addNewProduct(0 , p2 , store);
        managerAccount.addNewProduct(0 , p3 , store);
        managerAccount.addNewProduct(0 , p4 , store);
        Product p = store.FindProduct("milk");
        Customer customer1 = new Customer(1,"ba","@g0","faisel",010,100.0);
        p4.setShip();
        Cart cart1 = new Cart();
        cart1.add(p, 1);
        cart1.add(p, 1);
        cart1.showCartContent();
        Checkout(customer1 , cart1);
    }
    public static void Checkout(Customer custm , Cart cart){
        Map <String , ProductInformation> Products = cart.getProducts();
        if(Products.size() < 1){
            System.err.println("Cart is Empty");
            return ;
        }
        Double subTotal = 0.0 , shipping = 0.0 ;
        List <Service> shippableProduct = new ArrayList<>();
        System.out.println("** Checkout receipt **");
        for(ProductInformation pro : Products.values()){
             System.out.println(pro.getQuantityOrdered() + "x " + pro.getProductName() + "        " + pro.getProductPrice() );
             boolean fo = false;
             if(pro.getDate() != ""){
                LocalDate today = LocalDate.now();
                DateTimeFormatter f = DateTimeFormatter.ofPattern("d-M-yyyy");
                LocalDate inpuDate = LocalDate.parse(pro.getDate() , f);
                if(inpuDate.isAfter(today)){
                   fo = true;
                }
            }
             if(pro.getDate() == "" || fo){
                subTotal += (pro.getProductPrice() * pro.getQuantityOrdered());
                if(pro.isShippable()){
                    System.out.println(pro.getProductName() + pro.getWeight());
                    Service s = new Service(pro.getProductName(), pro.getWeight() , pro.getQuantityOrdered());
                    shippableProduct.add(s);
                }
             }
             else {
                System.out.println("Sorry! Product is Expired");
             }
             if(shippableProduct.size() > 0){ 
                ShippingService ship = new ShippingService(shippableProduct);
                shipping = ship.shippingObjects(custm.getAddress());
                if(shipping == -1){
                    return ;
                }
             }
             System.out.println("----------------------");
             System.out.println("SubTotal : " + subTotal);
             System.out.println("Shipping : " + shipping);
             System.out.println("Amount : " + (subTotal + shipping));
             if(custm.getBalance() < (subTotal + shipping)){
                System.err.println("Insufficicent money!!");
                return;
             }
             custm.setBalance(custm.getBalance() - (subTotal + shipping));

             System.out.println("Customer Balance After transaction : " + custm.getBalance());
        }



    }

}
