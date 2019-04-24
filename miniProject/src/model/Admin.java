package model;

public class Admin extends User {

    public Admin(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        User.add(this);
    }
}
