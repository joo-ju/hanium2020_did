package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.model.User;

import java.util.List;

public interface RequestService {
     List<Request> findOneByReqId(String reqId);

     List<Request> findAllByUser(User user);
//     List<Request> findAllByUserId(String userid);
}
