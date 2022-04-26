package com.mobilesoftwaredevelopment.finaldoctor.database;

public class GetDataModel {
    String name,email,fname;

    public GetDataModel(String name, String email, String fname) {
        this.name = name;
        this.email = email;
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
