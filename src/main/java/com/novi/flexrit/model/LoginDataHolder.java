package com.novi.flexrit.model;

public class LoginDataHolder {
    private String username;
    private String password;

    public LoginDataHolder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
