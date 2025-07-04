package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    List <Service> productList ;
    Map<String , Double> PlacesShipping = new HashMap<>();
    ShippingService(List<Service> products){
        productList = products;
        PlacesShipping.put("faisel" , 50.5);
        PlacesShipping.put("octobor" , 100.0);
        PlacesShipping.put("giza" , 10.0);
        PlacesShipping.put("haram" , 40.0);
    }

    public Double shippingObjects(String Place){
        if(PlacesShipping.containsKey(Place)){
            System.out.println("** Shipment notice **");
            Double total = 0.0;
            for(Service s : productList){
              System.out.println(s.getAmount() + "x  " + s.getName() + "  " + s.getWeight() + "g");
              total += s.getWeight();
            }
            System.out.println("Total package weight : " + (total / 1000) + "kg");
            return PlacesShipping.get(Place);
        }
        System.out.println("Out Of The Zone");
        return -1.0;
        
    }

}
