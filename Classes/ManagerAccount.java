package Classes;

import java.util.HashSet;
import java.util.Set;

public class ManagerAccount {
    Set <Integer> AccessList ;
    ManagerAccount(){
        AccessList = new HashSet<>();
        AccessList.add(0);
    }

    public void addAccess(Integer MyID , Integer ID ){
      if(AccessList.contains(MyID));
         AccessList.add(ID);
    }

    protected void addNewProduct(Integer ID , Product pro , Store store){
        if(AccessList.contains(ID))
          store.AllProducts.put(pro.getProductName() , pro);
        else 
          System.out.println("Acess Denied.");
    }

    protected void removeProduct(Integer ID , Product pro , Store store){
        if(AccessList.contains(ID))
          store.AllProducts.remove(pro.getProductName());
        else 
          System.out.println("Acess Denied.");
    }

}
