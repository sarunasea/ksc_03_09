package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
    public static void main(String[] args) {
        JdbcConnector jdbc = new JdbcConnector();
        Connection connection = jdbc.connect();
        if(connection == null){
            System.out.println("Nepavyko prisijungti prie DB");
        try {
            Statement statement = connection.createStatement();
            statement.execute("update from students set name = 'Petronzas' where id = 1");
        }
        catch (SQLException e){
            System.out.println("Nepavyko prisijungti prie DB");
        }
        }
}
}
