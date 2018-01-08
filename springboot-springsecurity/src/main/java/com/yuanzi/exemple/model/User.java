package com.yuanzi.exemple.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ZhouFangyuan on 2018/1/8. Information:
 */
@Entity(name = "sys_user")
public class User {

    @Id
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
