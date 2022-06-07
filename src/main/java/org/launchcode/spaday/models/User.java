package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {
    @NotBlank(message = "Username required.")
    @Size(min = 5, max = 15)
    private String username;

    @Email(regexp = ".+@.+\\..+||null", message= "Email is invalid.")
    private String email;

    @NotBlank(message = "Password required.")
    @Size(min = 6, message = "Password must be at lest 6 characters long")
    private String password;

    @NotBlank(message= "Verify password required")
    @Size(min = 6)
    private String verify;

    private int id;
    private static int nextId = 1;

    public User() {
        this.id = id;
        nextId++;
    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

//    private void checkPassword(){
//        if(!isNull(this.password && !isNull(this.verify) && !this.password.equals(this.verify = null)){
//
//        }
//    }

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

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
