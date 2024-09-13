package com.mysite.lesson28.model;

public class User {

    private String name;
    private String username;
    private String password;
    private byte[] avatar;

    public User() {
    }

    public User(String name, String username, String password, byte[] avatar) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
