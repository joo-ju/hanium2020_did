package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.RequestRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
//@Service("RequestService")
@Service
public class RequestServicempl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestService requestService;

    @Override
    public List<Request> findOneByReqId(String reqId){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(requestRepository.findOneByReqId(reqId));
    }
    @Override
    public List<Request> findAllByUser(User user) {
        return Lists.newArrayList(requestService.findAllByUser(user));
    }
//    @Override
//    public List<Request> findAllByUserId(String userid) {
//        return Lists.newArrayList(requestRepository.findAllByUserId(userid));
//    }
}
