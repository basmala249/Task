package Classes;

public class ProductInformation {
     private Integer QuantityOrdered;
     private String productName ;
     private Double productPrice;
     private String Date;
     private boolean shippable ; 
     private Double weight;
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
     public Double getProductPrice() {
         return productPrice;
     }
     public void setProductPrice(Double productPrice) {
         this.productPrice = productPrice;
     }
     public void updateQuantityOrdered(Integer quantity , Integer op){
         if((QuantityOrdered + (quantity * op)) < 0){
            System.err.println("You exceeded your balance");
            return ;
         }
         QuantityOrdered -= (quantity * op) ;
    }
     public String getDate() {
         return Date;
     }
     public void setDate(String date) {
         Date = date;
     }
     public boolean isShippable() {
         return shippable;
     }
     public void setShippable(boolean shippable) {
         this.shippable = shippable;
     }
     public Double getWeight() {
         return weight;
     }
     public void setWeight(Double weight) {
         this.weight = weight;
     } 
     
     

}
