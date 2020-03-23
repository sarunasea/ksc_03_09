package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.service.StudentAdddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/students/{studentID}/address")
public class StudentAddressController {
    private StudentAdddressService studentAdddressService;

    @Autowired
    public StudentAddressController(StudentAdddressService studentAdddressService){
        this.studentAdddressService = studentAdddressService;
    }

    @GetMapping
    public List<StudentAddress> getStudentAddress(@PathVariable ("studentID") String studentID){
        return studentAdddressService.getStudentaddresses(studentID);
    }

    @GetMapping("/{addressId}")
    public StudentAddress getStudentAddress(@PathVariable ("studentId") String studentId, @PathVariable("/addressId") String addressId){
        return studentAdddressService.getStudentaddresses(studentId, addressId);
    }
}
