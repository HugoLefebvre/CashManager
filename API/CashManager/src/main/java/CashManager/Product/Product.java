package CashManager.Product;

public class Product {
    Integer id;
    String pCode;
    String name;
    Integer prix_unit;


    public Product(Integer id, String pCode, String name, Integer prix_unit){
        this.id = id;
        this.pCode = pCode;
        this.name = name;
        this.prix_unit = prix_unit;
    }

    public Integer getId() { return id; }

    public String getpCode() {
        return pCode;
    }

    public String getName() {
        return name;
    }

    public Integer getPrix_unit() {
        return prix_unit;
    }
}