package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/studentId")
    public Student getStudent(@PathVariable("studentId") String studentID){


        return null;
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{studentID}/delete")
    public void delete(@PathVariable ("studentID") String studentID){
        studentService.deleteStudent(studentID);
    }

    @PutMapping("/{studentID}/update")
    public Student update(@PathVariable("studentID") String studentID, @RequestBody Student student){
        student.setId(Integer.parseInt(studentID));
        return studentService.updateStudent(student);
    }
}
