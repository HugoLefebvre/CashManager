package CashManager.Model;

public class PushProduct {

    int idUser;
    int idProduct;
    int quantity;

    public PushProduct(int idUser, int idProduct, int quantity) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }
}
