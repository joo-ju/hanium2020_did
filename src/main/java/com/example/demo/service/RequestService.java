package com.example.demo.service;

import com.example.demo.model.Request;

import java.util.List;

public interface RequestService {
     List<Request> findOneByReqId(String reqId);
}
