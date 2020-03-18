package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
    public Connection connect(){
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/duombaze", "root", "");
        }
        catch(SQLException e){
            System.out.println("Prisijungti nepavyko");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
