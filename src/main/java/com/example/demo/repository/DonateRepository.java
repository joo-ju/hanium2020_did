package com.example.demo.repository;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryDefinition(domainClass = Donate.class, idClass = String.class)
public interface DonateRepository extends JpaRepository<Donate, String> {
    List<Donate> findAll();



    List<Donate> findByRequest(Request request);









}