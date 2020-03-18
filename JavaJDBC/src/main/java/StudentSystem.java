import data.Student;
import jdbc.JdbcConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        int select;
        Scanner sc = new Scanner(System.in);
        StudentSystem system = new StudentSystem();
        do{

            System.out.println("________________________");
            System.out.println("|1. Įvesti naują studentą|");
            System.out.println("|0. Pabaiga|");
            System.out.println("________________________");
            select = sc.nextInt();
            switch(select){
                case 1:
                    system.createNewStudent(sc);
                    break;
                case 2:
                    system.selectAll(sc);
                    break;
                case 0:
                    System.out.println("Sistema baigia darbą");
                    break;
                default:
                    System.out.println("Nėra tokio veiksmo");
                    break;
            }
        }
        while(select != 0);

        }
        private void createNewStudent(Scanner sc){
            System.out.println("Iveskite studento vardą");
            String name = sc.next();
            System.out.println("Iveskite studento pavar1dę");
            String surname = sc.next();
            System.out.println("Iveskite studento telefoną");
            int phone = sc.nextInt();
            System.out.println("Iveskite studento e-pastą");
            String email = sc.next();

            JdbcConnector jdbc = new JdbcConnector();
            Connection connect = jdbc.connect();
            if(connect == null){
                System.out.println("Cannot create student");
            }
            try {
                PreparedStatement statement = connect.prepareStatement("inser into students (name, surname, phone, email)values(?, ?, ?, ?)");
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setInt(3, phone);
                statement.setString(4, email);
            }
            catch(SQLException e){
                System.out.println("Nepavyko prisijungti prie DB");
            }
        }
        private void selectAll(Scanner sc){
            JdbcConnector jdbc = new JdbcConnector();
            Connection connect = jdbc.connect();
            if(connect == null){
                System.out.println("Cannot create student");
            }
            List<Student> students = new ArrayList<>();
            try {
                Statement statement = connect.createStatement();
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
                System.out.println("Nepavyko prisijungti prie DB");
            }
            students.forEach(student ->{
                System.out.print(student.getId() +" " + student.getName() +" " + student.getSurname() +" " + student.getPhone() + " " + student.getEmail() + "|");
            });
        }
    }

