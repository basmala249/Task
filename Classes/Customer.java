package Classes;

public class Customer {
    private Integer nationalID ;
    private String name;
    private String email;
    private String Address ;
    private Integer phone;
    private Double Balance;
    Customer(Integer ID , String name , String email , String Address , Integer phone , Double Balance){
        this.nationalID = ID;
        this.name = name;
        this.email = email;
        this.Address = Address;
        this.phone = phone;
        this.Balance = Balance;
    }
    public Integer getNationalID() {
        return nationalID;
    }
    public void setNationalID(Integer nationalID) {
        this.nationalID = nationalID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public Double getBalance() {
        return Balance;
    }
    public void setBalance(Double balance) {
        Balance = balance;
    }

    public void updateBalance(Integer quantity , Integer op){
         if((Balance + (quantity * op)) < 0){
            System.err.println("You exceeded your balance");
            return ;
         }
         Balance -= (quantity * op) ;
    }

    
}
