package com.example.demo.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="\"user\"")
@Data
public abstract class User {
    @NonNull
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_birth")
    private int userBirth;

    @Column(name = "user_gender")
    private int userGender;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_inputdate")
    private String userInputdate;

    @ManyToOne
    @JoinColumn(name = "g_id")
    private Group group;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(int userBirth) {
        this.userBirth = userBirth;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInputdate() {
        return userInputdate;
    }

    public void setUserInputdate(String userInputdate) {
        this.userInputdate = userInputdate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}