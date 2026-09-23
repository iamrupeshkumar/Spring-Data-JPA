package com.rupeshkumar.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rupeshkumar.springdatajpa.entity.Player;

//@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{

}
