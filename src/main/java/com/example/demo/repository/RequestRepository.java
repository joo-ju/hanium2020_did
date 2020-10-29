package com.example.demo.repository;

import com.example.demo.model.request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<request, String> {
    public void request_create(request re);

    public request request_read(String req_id);

    public void request_update(request re);

    public void request_delete(String req_id);

    public List<request> request_listAll();
}
