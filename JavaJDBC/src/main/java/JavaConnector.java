import data.Student;
import jdbc.JdbcConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaConnector {
    public static void main(String[] args) {
        /*
        1. Sukurti connection
        2. Sukurti is connetion statement
        3. Execute statement
        */
            //1
            JdbcConnector jdbc = new JdbcConnector();
            Connection connection = jdbc.connect();
            if(connection == null){
                return;
            }
            //2
        List<Student> students = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            //3
            ResultSet resultSet = statement.executeQuery("select * from students");
            while(resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("phone"),
                        resultSet.getString("email")));
            }


            }
        catch(SQLException e){
            System.out.println("Prisijungti nepavyko");
            System.out.println(e.getMessage());
            }
        students.forEach(student ->{
            System.out.println(student.getId());
            System.out.println(student.getSurname());
        });
    }
}
