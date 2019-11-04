package CashManager.Database;

import java.sql.*;

public class Database {
    public Connection conn;
    public Database(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CashManager","root","");

        }catch(Exception e){ System.out.println(e);}
    }

}
