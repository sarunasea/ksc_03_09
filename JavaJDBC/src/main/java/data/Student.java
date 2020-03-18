package data;

public class Student {
    private int id;
    private String name;
    private String surname;
    private int phone;
    private String email;

    public Student(int id, String name, String surname, int phone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
