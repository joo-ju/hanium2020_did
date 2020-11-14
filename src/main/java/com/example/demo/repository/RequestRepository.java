package com.example.demo.repository;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
     public List<Request> findOneByReqId(String reqId);
     List<Request> findAllByUser(User user);
//     List<Request> findAllByUserId(final String userid);
}
