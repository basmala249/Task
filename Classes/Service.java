package Classes;

public class Service implements Shipping{
    private Double weight;
    private String name;
    private Integer amount ;
    public Service(String name, Double weight , Integer amount) {
        this.weight = weight;
        this.name = name;
        this.amount = amount;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
     
}
