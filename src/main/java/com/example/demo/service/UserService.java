package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
//    void updateByUserId(String no, String user);
     User findByUserId(String userId);
     User save(User user);
}
