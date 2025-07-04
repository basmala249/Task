package Classes;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map <String , ProductInformation> Products ;
    Cart(){
        Products = new HashMap<>();
    }

    Integer getCartSize(){
        return Products.size();
    }

    Map <String , ProductInformation> getProducts(){
        return Products;
    }
     
    void showCartContent(){
         for (ProductInformation pro : Products.values()) { 
            System.out.println(pro.getQuantityOrdered() + "x " + pro.getProductName() + "        " + pro.getProductPrice() );
          }
    }
    
    void add(Product pro , Integer quantityOrdered){
        if(pro == null){
            System.out.println("You should Enter Valid Product");
            return ;
        }
        if(quantityOrdered < 0){
            System.out.println("You should Enter Positive Number");
            return ;
        }
        if(pro.getProductCount() < quantityOrdered){
            System.err.println("You exceeded Available Stock!");
            if(pro.getProductCount() > 0)
              System.out.println("Only " + pro.getProductCount() + " available to order.");
            else {
                System.out.println("No Avaiable Stocks.");
            }
            return ;
        }
        if(Products.containsKey(pro.getProductName())){
            ProductInformation p = Products.get(pro.getProductName());
            p.setQuantityOrdered(quantityOrdered + p.getQuantityOrdered());
        }
        else {
            ProductInformation product = new ProductInformation();
            product.setProductName(pro.getProductName());
            product.setProductPrice(pro.getProductPrice());
            product.setQuantityOrdered(quantityOrdered);
            Products.put(pro.getProductName(), product);
        }
        pro.updateProductCount(quantityOrdered,  -1);
         
        
    }
    
    void removeProduct(Product pro){
        if(Products.containsKey(pro.getProductName())){
            Products.remove(pro.getProductName());
        }
        else {
            System.out.println("Product not Found.");
        }
    }
    
    void removeQuantityFromProduct(Product pro , Integer quantity){
       if(Products.containsKey(pro.getProductName())){
            Integer Val = Products.get(pro.getProductName()).getQuantityOrdered();
            if(Val < quantity){
                System.out.println("You just Ordered Only " + Val + " From the Product.");
            }
            else {
                Val -= quantity;
                Products.get(pro.getProductName()).updateQuantityOrdered(quantity, -1);
                pro.updateProductCount(quantity , 1);
            }
        }
        else {
            System.out.println("Product not Found.");
        }
    }


}
