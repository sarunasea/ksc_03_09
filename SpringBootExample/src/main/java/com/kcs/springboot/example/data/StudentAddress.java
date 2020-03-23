package com.kcs.springboot.example.data;

public class StudentAddress {

    private int iD;
    private int studentID;
    private String country;
    private String city;
    private String street;
    private String postCode;

    public StudentAddress(int studentID, String country, String city, String street, String postCode) {
        this.studentID = studentID;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public StudentAddress(int iD, int studentID, String country, String city, String street, String postCode){
        this(studentID, country, city, street, postCode);
        this.iD = iD;
    }
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
