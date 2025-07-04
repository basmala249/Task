package Classes;

public class Product {
    private String productName;
    private Integer productID;
    private Integer productCount;
    private Double productPrice;
    private boolean shippable = false;
    private String expireDate = "";
    private Double weight ;
    public Product(String productName, Integer productID, Integer productCount, Double productPrice , Double weight) {
        this.productName = productName;
        this.productID = productID;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.weight = weight;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductID(Integer productID) {
        this.productID = productID;
    }
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductName() {
        return productName;
    }
    public Integer getProductID() {
        return productID;
    }
    public Integer getProductCount() {
        return productCount;
    }
    public Double getProductPrice() {
        return productPrice;
    }

    public void updateQuantity(Integer quantity){
        productCount += quantity;
    }
    
    public void updateProductCount(Integer quantity , Integer op){
         if((productCount + (quantity * op)) < 0){
            System.err.println("You exceeded your count of product , it is only available");
            return ;
         }
         productCount -= (quantity * op) ;
    }
    public void setShip(){
        shippable = true;
    }
    public boolean Shippable(){
        return shippable ;
    }
   
    public void setExpire(String date){
        expireDate = date;
    }
    public String getExpireDate(){
        return expireDate;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    
}
