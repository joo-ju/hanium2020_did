package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface DonateService {
    List<Donate> findAll();
    public List<Donate> findAllByUser(User user);
//    List<Donate> findAllByUserId(String userId);
    List<Donate> findByRequest(Request request);
}
