package model;

public class Teacher extends User {

    public Teacher(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        User.add(this);
    }
}
