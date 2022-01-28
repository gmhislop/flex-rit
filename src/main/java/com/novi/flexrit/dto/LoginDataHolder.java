package com.novi.flexrit.dto;

public class LoginDataHolder {
    private final String username;
    private final String password;

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
