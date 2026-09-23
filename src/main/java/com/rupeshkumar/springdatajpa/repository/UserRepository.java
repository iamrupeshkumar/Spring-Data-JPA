package com.rupeshkumar.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.rupeshkumar.springdatajpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
