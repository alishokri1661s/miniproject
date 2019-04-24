package model;

public class Student extends User {

    public Student(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        User.add(this);
    }
}
