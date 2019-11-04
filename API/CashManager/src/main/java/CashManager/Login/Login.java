package CashManager.Login;

import CashManager.Database.Database;

public class Login {
    public String Login(String username, String password){
        Database db = new Database();
        if(username == null || password == null)
            return "ERR_EMPTY";
        else
            return "SUCCESS";
    }

    public String Register(String username, String password){

        if(username == null || password == null)
            return "ERR_EMPTY";
        else
            return "SUCCESS";
    }
}
