package com.User_service.User_Service.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_details_info")
//@NamedQuery(name="user_details_info.findAll", query="select e from user_details_info e")
public class UserManagementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "username")
    private String username;

    @Column(name = "user_email")
    private String usermail;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "password")
    private String password;

}
