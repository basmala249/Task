package Classes; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       //Product p = new Product();
    
    }
    public void Checkout(Customer custm , Cart cart){
        Map <String , ProductInformation> Products = cart.getProducts();
        if(Products.size() < 1){
            System.err.println("Cart is Empty");
            return ;
        }
        Double subTotal = 0.0 , shipping = 0.0 ;
        List <ProductInformation> shippableProduct = new ArrayList<>();
        System.out.println("** Checkout receipt **");
        for(ProductInformation pro : Products.values()){
             System.out.println(pro.getQuantityOrdered() + "x " + pro.getProductName() + "        " + pro.getProductPrice() );
             LocalDate today = LocalDate.now();
             DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             LocalDate inpuDate = LocalDate.parse(pro.getDate() , f);
             if(inpuDate.isAfter(today)){
                subTotal += (pro.getProductPrice() * pro.getQuantityOrdered());
                if(pro.isShippable()){
                    shippableProduct.add(pro);
                }
             }
             else {
                System.out.println("Sorry! Product is Expired");
             }
             if(shippableProduct.size() > 0){
                //shipping = getShipping();
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
