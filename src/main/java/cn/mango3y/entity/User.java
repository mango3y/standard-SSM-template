package cn.mango3y.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean gender;
    private Date registerTime;

    public User() {
    }

    public User(Integer id, String username, String password, Boolean gender, Date registerTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.registerTime = registerTime;
    }

}
