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

    public Product FindProduct(String s){
        if(AllProducts.containsKey(s.toLowerCase())){
            System.out.println("It is avaiable.");
            Product p = AllProducts.get(s.toLowerCase());
            return p;
        }
        else {
            System.out.println("Not Found.");
            return null;
        }
    }
    
    

}
