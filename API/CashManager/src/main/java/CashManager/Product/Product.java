package CashManager.Product;

public class Product {
    int id;
    String pCode;
    String name;
    Integer prix_unit;

    public Product(String pCode, String name, Integer prix_unit){
        this.pCode = pCode;
        this.name = name;
        this.prix_unit = prix_unit;
    }

    public Product(int id, String pCode, String name, Integer prix_unit){
        this.id = id;
        this.pCode = pCode;
        this.name = name;
        this.prix_unit = prix_unit;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(Integer prix_unit) {
        this.prix_unit = prix_unit;
    }
}