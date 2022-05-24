package org.launchcode.spaday.models;

import java.util.Date;
import java.util.Objects;

public class User {

    private int id;
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private Date date;

    public User(String username, String email, String password, Date date) {
        this.id = nextId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = date;
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getNextId() {
        return nextId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
