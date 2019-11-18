package CashManager.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    int idUser;
    List<Product> listProduct = new ArrayList<>();

    public Cart(int id, List<Product> products){
        this.idUser = id;
        this.listProduct = products;
    }

    public int getIdUser() {
        return idUser;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
}
