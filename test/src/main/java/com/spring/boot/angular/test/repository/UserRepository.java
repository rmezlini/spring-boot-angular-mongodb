package com.spring.boot.angular.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.angular.test.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{}
