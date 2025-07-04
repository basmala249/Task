package Classes;

public class ProductInformation {
     private Integer QuantityOrdered;
     private String productName ;
     private Integer productPrice;

     public Integer getQuantityOrdered() {
         return QuantityOrdered;
     }
     public void setQuantityOrdered(Integer quantityOrdered) {
         QuantityOrdered = quantityOrdered;
     }
     public String getProductName() {
         return productName;
     }
     public void setProductName(String productName) {
         this.productName = productName;
     }
     public Integer getProductPrice() {
         return productPrice;
     }
     public void setProductPrice(Integer productPrice) {
         this.productPrice = productPrice;
     }
     public void updateQuantityOrdered(Integer quantity , Integer op){
         if((QuantityOrdered + (quantity * op)) < 0){
            System.err.println("You exceeded your balance");
            return ;
         }
         QuantityOrdered -= (quantity * op) ;
    }     
}
