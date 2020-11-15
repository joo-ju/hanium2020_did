package com.example.demo.repository;

import com.example.demo.model.Group;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, String> {

}
