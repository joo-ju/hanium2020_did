package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface UserRepository extends JpaRepository<User, String> {
//    void updateByUserId(String userId, String user);
     User findByUserId(String userName);
     User save(User user);
}
