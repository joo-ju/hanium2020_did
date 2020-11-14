package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface DonateService {
    List<Donate> findAll();
    List<Donate> findByRequest(Request request);
}
