package com.example.demo.service;


import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("DonateService")
public class DonateServicempl implements DonateService  {
    @Autowired
    private DonateService donateService;
    @Autowired
    private DonateRepository donateRepository;

    @Override
    public List<Donate> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(donateRepository.findAll());
    }
    @Override
    public List<Donate> findByRequest(Request request){
        return Lists.newArrayList(donateRepository.findByRequest(request));

    }

    @Override
    public List<Donate> findAllByUser(User user) {
        return Lists.newArrayList(donateService.findAllByUser(user));
    }
//    @Override
//    public List<Donate> findAllByUserId(String userId) {
//        return Lists.newArrayList(donateRepository.findAllByUserId(userId));
//    }
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository){
        this.donateRepository = donateRepository;
    }
}