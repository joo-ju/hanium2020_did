package com.example.demo.repository;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@RepositoryDefinition(domainClass = Donate.class, idClass = String.class)
public interface DonateRepository extends JpaRepository<Donate, String> {
    List<Donate> findAll();
    List<Donate> findAllByUser(User user);
//    List<Donate> findAllByUserId(String user);
    List<Donate> findByRequest(Request request);









}