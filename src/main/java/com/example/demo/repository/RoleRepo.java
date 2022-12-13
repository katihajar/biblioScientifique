package com.example.demo.repository;

import com.example.demo.document.Documents;
import com.example.demo.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends MongoRepository<Role, String> {

}
