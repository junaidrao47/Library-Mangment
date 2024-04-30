package com.example.selibrary;

import java.io.IOException;
import java.io.Serializable;

public class Student  extends User {
    Account a1 = new Account();
    // Attributes
    private String Name;
    private int id;
    private String gmail;
    private String phonenumber;

    public Student() throws IOException {
    }


    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }
//Getter and Setters


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    void Signup() {
        try {
            super.Signup();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void Logout() {
        super.Logout();
    }

    @Override
    public void Login() throws IOException, ClassNotFoundException {
        super.Login();
    }
}


