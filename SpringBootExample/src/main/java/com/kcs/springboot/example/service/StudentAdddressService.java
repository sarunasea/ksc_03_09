package com.kcs.springboot.example.service;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.jdbc.JdbcConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAdddressService {
    private JdbcConnector jdbc;

    @Autowired
    public StudentAdddressService(JdbcConnector jdbc){
        this.jdbc = jdbc;
    }

    public List<StudentAddress> getStudentaddresses(String studentID){
        List<StudentAddress> studentAddresses = new ArrayList<>();
        Connection connection = jdbc.createConnection();
        if(connection == null){
            return null;
        }
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_address where student_id = ?");
            preparedStatement.setInt(1, Integer.parseInt(studentID));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                studentAddresses.add(convertToStudentAddress(resultSet));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return studentAddresses;
    }

    private StudentAddress convertToStudentAddress(ResultSet resultSet) throws SQLException {
        return new StudentAddress(resultSet.getInt("iD"),
                                resultSet.getString("country"),
                                resultSet.getString("city"),
                                resultSet.getString("street"),
                                resultSet.getString("postCode"));
    }

    public StudentAddress getStudentAddress(String studentId, String addressId){
        try{
            PreparedStatement preparedStatement = jdbc.getPreparedStatement("select * from student_address where student_id = ?, and id =?");
            preparedStatement.setInt(1, Integer.parseInt(studentId));
            preparedStatement.setInt(2,Integer.parseInt(addressId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return convertToStudentAddress(resultSet);
    }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
}
}
