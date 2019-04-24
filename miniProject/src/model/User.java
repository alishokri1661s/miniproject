package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static final List<User> ALL_USERS = new ArrayList<>();
    private String username;
    private String password;

    public static void initUsers() {
        new Admin("admin","adminpass");
        new Teacher("aliakbari","sadegh");
        new Teacher("malek","gosaste2");
        new Student("ali.shokri","alishokri");
        new Student("alialavi","password");
        new Student("me","97243042");
        new Student("my_username","my_password");
    }

    public static int search(String username) {
        for (int i = 0; i < ALL_USERS.size(); i++)
            if (ALL_USERS.get(i).getUsername().equalsIgnoreCase(username))
                return i;
        return -1;
    }

    public static void add (User user) {
            ALL_USERS.add(user);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length()>=6)
            this.password = password;
        else
            throw new RuntimeException();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (User.search(username)==-1)
            this.username = username;
        else
            throw new RuntimeException();
    }

    @Override
    public boolean equals(Object obj) {
        User other= (User) obj;
        if (other.username.equalsIgnoreCase(this.username))
            return true;
        return false;
    }
}
