package com.example.demo.service;

import com.example.demo.model.Donate;

import java.util.List;

// 기부내역 서비스
public interface DonateService {
    List<Donate> findAll();

}
