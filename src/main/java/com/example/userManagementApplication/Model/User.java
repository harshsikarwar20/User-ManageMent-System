package com.example.userManagementApplication.Model;

public class User {
    private int id;
    private String name;
    private String username;
    private String address;
    private String phoneNum;

    public User(int id, String name, String username, String address, String phoneNum){
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString(){
        return "manage{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",username='" + username + '\'' +
                ",address='" + address + '\'' +
                ",phoneNumber='" + phoneNum +
                "}";
    }
}