package Classes;
 
import java.util.HashMap; 
import java.util.Map;

public class Store {
    Map<String , Product> AllProducts;
    
    Store(){
       AllProducts = new HashMap<>();
    }

    public Map<String , Product> getAllProducts(){
        return AllProducts;
    }

    public void FindProduct(Product pro){
        if(AllProducts.containsKey(pro.getProductName())){
            System.out.println("It is avaiable.");
        }
        else {
            System.out.println("Not Found.");
        }
    }
    
    

}
